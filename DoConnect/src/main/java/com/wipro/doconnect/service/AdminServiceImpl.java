/*@Author:Rajesh
Modified Date:30-08-2022
Description:AdminServiceImpl class which implements the methods of AdminService interface and provide services to perform admin CURD operations.
*/


package com.wipro.doconnect.service;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wipro.doconnect.dto.ResponseDTO;
import com.wipro.doconnect.entity.Admin;
import com.wipro.doconnect.entity.Answer;
import com.wipro.doconnect.entity.Question;
import com.wipro.doconnect.entity.User;
import com.wipro.doconnect.exception.AlreadyThere;
import com.wipro.doconnect.exception.NotFound;
import com.wipro.doconnect.repository.AdminRepository;
import com.wipro.doconnect.repository.AnswerRepository;
import com.wipro.doconnect.repository.QuestionRepository;
import com.wipro.doconnect.repository.UserRepository;
import com.wipro.doconnect.service.AdminService;
import com.wipro.doconnect.service.EmailSenderService;

@Service
public class AdminServiceImpl implements AdminService
{
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private AnswerRepository answerRepository;


	/*@Author:Rajesh
	Modified Date:30-08-2022
	Description:admin login service.
	Params:email, password
	ReturnType:Admin
	Exception:NotFound
	*/

	@Override
	public Admin adminLogin(String email, String password)
	{
		Admin admin = adminRepository.findByEmail(email);
		if (Objects.isNull(admin))
			throw new NotFound();

		if (admin.getPassword().equals(password))
		{
			admin.setIsActive(true);
			adminRepository.save(admin);
		}
		else
			throw new NotFound();
		return admin;
	}

	/*@Author:Rajesh
	Modified Date:30-08-2022
	Description:admin logout service.
	Params:adminId
	ReturnType:String
	Exception:NotFound
	*/
	@Override
	public String adminLogout(Long adminId)
	{
		Admin admin = adminRepository.findById(adminId).orElseThrow(() -> new NotFound("Admin not found"));
		admin.setIsActive(false);
		adminRepository.save(admin);
		return "Logged Out";
	}

	/*@Author:Rajesh
	Modified Date:30-08-2022
	Description:admin register service.
	Params:admin
	ReturnType:Admin
	Exception:AlreadyThere
	*/
	@Override
	public Admin adminRegister(Admin admin)
	{
		Admin admin1 = adminRepository.findByEmail(admin.getEmail());
			if (Objects.isNull(admin1))
				return adminRepository.save(admin);
			

		throw new AlreadyThere();
	}

	/*@Author:Rajesh
	Modified Date:30-08-2022
	Description:admin getUser service.
	Params:email
	ReturnType:User
	*/
	@Override
	public User getUser(String email)
	{
		return userRepo.findByEmail(email);
	}

	/*@Author:Rajesh
	Modified Date:30-08-2022
	Description:admin getAllUser service.
	ReturnType:List
	*/
	@Override
	public List<User> getAllUser()
	{
		return userRepo.findAll();
	}

	/*@Author:Rajesh
	Modified Date:30-08-2022
	Description:getting unapproved questions service.
	ReturnType:List
	*/
	@Override
	public List<Question> getUnApprovedQuestions()
	{
		return questionRepository.findByIsApproved();
	}

	/*@Author:Rajesh
	Modified Date:30-08-2022
	Description:admin login service.
	ReturnType:List
	*/
	@Override
	public List<Answer> getUnApprovedAnswers()
	{
		return answerRepository.findByIsApproved();
	}

	/*@Author:Rajesh
	Modified Date:30-08-2022
	Description:approve question service.
	Params:questionId
	ReturnType:Question
	Exception:NotFound
	*/
	@Override
	public Question approveQuestion(Long questionId)
	{
		Question question = questionRepository.findById(questionId).orElseThrow(() -> new NotFound("Question not found"));

		question.setIsApproved(true);
		question = questionRepository.save(question);
		return question;
	}

	/*@Author:Rajesh
	Modified Date:30-08-2022
	Description:approve answer service.
	Params:answerId
	ReturnType:Answer
	Exception:NotFound
	*/
	@Override
	public Answer approveAnswer(Long answerId)
	{
		Answer answer = answerRepository.findById(answerId).orElseThrow(() -> new NotFound("Answer not found"));

		answer.setIsApproved(true);
		answer = answerRepository.save(answer);
		return answer;
	}

	/*@Author:Rajesh
	Modified Date:30-08-2022
	Description:delete question service.
	Params:questionId
	ReturnType:ResponseDTO
	Exception:NotFound
	*/
	@Override
	public ResponseDTO deleteQuestion(Long questionId)
	{
		ResponseDTO responseDTO = new ResponseDTO();
		Question question = questionRepository.findById(questionId).orElseThrow(() -> new NotFound("Question not found"));

		questionRepository.delete(question);
		responseDTO.setMsg("Question removed");
		return responseDTO;
	}

	/*@Author:Rajesh
	Modified Date:30-08-2022
	Description:delete answer service.
	Params:answerId
	ReturnType:ResponseDTO
	Exception:NotFound
	*/
	@Override
	public ResponseDTO deleteAnswer(Long answerId)
	{
		ResponseDTO responseDTO = new ResponseDTO();

		Answer answer = answerRepository.findById(answerId).orElseThrow(() -> new NotFound("Answer not found"));

		answerRepository.delete(answer);
		responseDTO.setMsg("Answer Removed");
		return responseDTO;
	}
}
