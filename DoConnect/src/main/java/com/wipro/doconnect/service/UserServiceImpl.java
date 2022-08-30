/*@Author:Chakradhar
Modified Date:30-08-2022
Description:UserServiceImpl implementation class for interface UserService.
*/


package com.wipro.doconnect.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import javax.persistence.EntityManager;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import com.wipro.doconnect.dto.AskQuestionDTO;
import com.wipro.doconnect.dto.Message;
import com.wipro.doconnect.dto.PostAnswerDTO;
import com.wipro.doconnect.entity.Admin;
import com.wipro.doconnect.entity.Answer;
import com.wipro.doconnect.entity.ImageModel;
import com.wipro.doconnect.entity.Question;
import com.wipro.doconnect.entity.User;
import com.wipro.doconnect.exception.AlreadyThere;
import com.wipro.doconnect.exception.NotFound;
import com.wipro.doconnect.repository.AdminRepository;
import com.wipro.doconnect.repository.AnswerRepository;
import com.wipro.doconnect.repository.ImageModelRepository;
import com.wipro.doconnect.repository.QuestionRepository;
import com.wipro.doconnect.repository.UserRepository;
import com.wipro.doconnect.service.EmailSenderService;
import com.wipro.doconnect.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private QuestionRepository questionRepo;
	@Autowired
	private AnswerRepository answerRepo;
	@Autowired
	private EntityManager entityManager;
	@Autowired
	private ImageModelRepository imageModelRepo;
	@Autowired
	private EmailSenderService emailSenderService;
	@Autowired
	private RestTemplate restTemplate;

	/*@Author:Chakradhar
	Modified Date:30-08-2022
	Description:User login service.
	Params:email, password
	ReturnType:User
	Exception:NotFound
	*/
	@Override
	public User userLogin(String email, String password) {
		User user = userRepo.findByEmail(email);
		if (Objects.isNull(user))
			throw new NotFound();

		if (user.getPassword().equals(password)) {
			user.setIsActive(true);
			userRepo.save(user);
		} else
			throw new NotFound();
		return user;
	}

	/*@Author:Chakradhar
	Modified Date:30-08-2022
	Description:User logout service.
	Params:userId
	ReturnType:String
	Exception:NotFound
	*/
	@Override
	public String userLogout(Long userId) {
		User user = userRepo.findById(userId).orElseThrow(() -> new NotFound("User Not Found" + userId));
		user.setIsActive(false);
		userRepo.save(user);
		return "Logged Out";
	}

	/*@Author:Chakradhar
	Modified Date:30-08-2022
	Description:User registration service.
	Params:user
	ReturnType:User
	Exception:AlreadyThere
	*/
	@Override
	public User userRegister(User user) {
		User user1 = userRepo.findByEmail(user.getEmail());
		if (Objects.isNull(user1))
			return userRepo.save(user);
		throw new AlreadyThere();
	}

	/*@Author:Chakradhar
	Modified Date:30-08-2022
	Description:askQuestion service.
	Params:askQuestionDTO
	ReturnType:Question
	Exception:NotFound
	*/
	@Override
	public Question askQuestion(AskQuestionDTO askQuestionDTO) {
		Question question = new Question();
		User user = userRepo.findById(askQuestionDTO.getUserId()).orElseThrow(() -> new NotFound("User Not Found"));
		question.setQuestion(askQuestionDTO.getQuestion());
		question.setTopic(askQuestionDTO.getTopic());
		question.setUser(user);
		question.setCreatedDate(new Date());
		questionRepo.save(question);
		List<Admin> admins = adminRepository.findAll();
		for (Admin admin : admins)
		{
			sendMail(admin.getEmail(), "Question Added by "+user.getName());
		}
		return question;
	}

	/*@Author:Chakradhar
	Modified Date:30-08-2022
	Description:giveanswer service.
	Params:postAnswerDTO
	ReturnType:Answer
	Exception:NotFound
	*/
	@Override
	public Answer giveAnswer(@Valid PostAnswerDTO postAnswerDTO) {
		Answer answer = new Answer();
		User answerUser = userRepo.findById(postAnswerDTO.getUserId())
				.orElseThrow(() -> new NotFound("User Not Found"));

		Question question = questionRepo.findById(postAnswerDTO.getQuestionId())
				.orElseThrow(() -> new NotFound("Question Not Found"));
		answer.setQuestion(question);
		answer.setAnswer(postAnswerDTO.getAnswer());
		answer.setAnswerUser(answerUser);
		answer.setCreatedDate(new Date());

		answerRepo.save(answer);
		
		List<Admin> admins = adminRepository.findAll();
		for (Admin admin : admins)
		{
			sendMail(admin.getEmail(), "Answer Added by "+answerUser.getName());
		}
		
		return answer;
	}

	/*@Author:Chakradhar
	Modified Date:30-08-2022
	Description:get answer service.
	Params:questionId
	ReturnType:List
	*/
	@Override
	public List<Answer> getAnswers(Long questionId) {
		return answerRepo.findByQuestionId(questionId);
	}

	/*@Author:Chakradhar
	Modified Date:30-08-2022
	Description:delete answer service.
	Params:topic
	ReturnType:List
	*/
	@Override
	public List<Question> getQuestions(String topic) {
		if (topic.equalsIgnoreCase("All")) {
			return questionRepo.findByIsApprovedTrue();
		}
		return questionRepo.findByTopicAndApproved(topic);
	}

	/*@Author:Chakradhar
	Modified Date:30-08-2022
	Description:searchQuestion service.
	Params:question
	ReturnType:List
	*/
	@Override
	public List<Question> searchQuestion(String question) {
		String sqlQuery = "from Question where (question like :question) and isApproved = 1";
		return entityManager.createQuery(sqlQuery, Question.class).setParameter("question", "%" + question + "%")
				.getResultList();
	}

	/*@Author:Chakradhar
	Modified Date:30-08-2022
	Description:uploadImage service.
	Params:file
	ReturnType:BodyBuilder
	Exception:IOException
	*/
	@Override
	public BodyBuilder uplaodImage(MultipartFile file) throws IOException {
		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		ImageModel img = new ImageModel(file.getOriginalFilename(), file.getContentType(),
				compressBytes(file.getBytes()));
		imageModelRepo.save(img);
		return ResponseEntity.status(HttpStatus.OK);
	}

	/*@Author:Chakradhar
	Modified Date:30-08-2022
	Description:getImage service.
	Params:imageName
	ReturnType:ImageModel
	*/
	@Override
	public ImageModel getImage(String imageName) {
		final Optional<ImageModel> retrievedImage = imageModelRepo.findByName(imageName);
		if(retrievedImage.isPresent())
		{
			ImageModel img = new ImageModel(retrievedImage.get().getName(), retrievedImage.get().getType(), decompressBytes(retrievedImage.get().getPicByte()));
			return img;
		}
		return null;
	}

	/*@Author:Chakradhar
	Modified Date:30-08-2022
	Description:sendMessage service.
	Params:message
	ReturnType:Message
	*/
	@Override
	public Message sendMessage(@Valid Message message) {
		String url = "http://localhost:9091/chat/sendMessage";
		ResponseEntity<Message> responseEntity = restTemplate.postForEntity(url, message, Message.class);
		Message response = responseEntity.getBody();

		return response;
	}

	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();
	}

	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}
	
	/*@Author:Chakradhar
	Modified Date:30-08-2022
	Description:sendMail service.
	Params:emailId, type
	ReturnType:Boolean
	Exception:Failure Sending mail
	*/
	public Boolean sendMail(String emailId, String type)
	{
		try
		{
			emailSenderService.sendEmail(emailId, type, type);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("error in sending mail " + e);
			return false;
		}
	}
}
