package com.wipro.doconnect.service;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wipro.doconnect.entity.Admin;
import com.wipro.doconnect.entity.Answer;
import com.wipro.doconnect.entity.Question;
import com.wipro.doconnect.entity.User;
import com.wipro.doconnect.repository.AdminRepository;
import com.wipro.doconnect.repository.AnswerRepository;
import com.wipro.doconnect.repository.QuestionRepository;
import com.wipro.doconnect.repository.UserRepository;

class UserServiceImplTest {
	
	@Autowired
	AdminServiceImpl service;
	
	@Autowired
	AdminRepository adminRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	QuestionRepository questionRepo;

	@Autowired
	AnswerRepository answerRepo;

	@Test
	void testUserLogin() {
		User user= userRepo.findByEmail("pavan@gmail.com");
		assertEquals("987654321",user.getPassword());
	}

	@Test
	void testUserLogout() {
	User user= userRepo.findById(1L).get();
	user.setIsActive(false);
	userRepo.save(user);
	}

	@Test
	void testUserRegister() {
		User user = new User();
		user.setId(1L);
		user.setEmail("pavan@gmail.com");
		user.setName("pavan");
		user.setPassword("987654321");
		user.setPhoneNumber("9876543210");
		user.setIsActive(true);
		userRepo.save(user);
		assertNotNull(userRepo.findById(1L).get());	
		
	}

	@Test
	void testAskQuestion() {
		Date dateobj = new Date();
		Question question = new Question();
		User user = userRepo.findById(1L).get();
		question.setId(1L);
		question.setTopic("Java");
		question.setQuestion("What is Java?");
		question.setIsApproved(false);
		question.setCreatedDate(dateobj);
		question.setUser(user);
	}

	@Test
	void testGiveAnswer() {
		Answer answer = new Answer();
		User answerUser = userRepo.findById(1L).get();
		Question question = questionRepo.findById(1L).get();
		answer.setQuestion(question);
		answer.setAnswer("Java is Programming Language");
		answer.setAnswerUser(answerUser);
		answer.setCreatedDate(new Date());
	}

	@Test
	void testGetAnswers() {
		List<Answer> answerList = answerRepo.findByQuestionId(1l);
	}

	@Test
	void testGetQuestions() {
		questionRepo.findByIsApprovedTrue();
	}

	@Test
	void testSearchQuestion() {
		List<Question> questionList = questionRepo.findAll();
	}



}
