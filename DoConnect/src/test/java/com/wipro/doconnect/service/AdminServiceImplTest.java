package com.wipro.doconnect.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wipro.doconnect.entity.Admin;
import com.wipro.doconnect.entity.Answer;
import com.wipro.doconnect.entity.Question;
import com.wipro.doconnect.entity.User;
import com.wipro.doconnect.repository.AdminRepository;
import com.wipro.doconnect.repository.AnswerRepository;
import com.wipro.doconnect.repository.QuestionRepository;
import com.wipro.doconnect.repository.UserRepository;


@SpringBootTest
class AdminServiceImplTest {
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
	void testAdminLogin() {
		Admin admin=adminRepo.findByEmail("pavan@gmail.com");
		assertEquals("987654321",admin.getPassword());
		

	}

	
	@Test 
	void testAdminLogout() {
		Admin admin = adminRepo.findById(1L).get();
		admin.setIsActive(false);
		adminRepo.save(admin);
	  }
	 
	@Test
	void testAdminRegister() {
		Admin admin = new Admin();
		admin.setId(3L);
		admin.setEmail("pavan@gmail.com");
		admin.setName("pavan");
		admin.setPassword("987654321");
		admin.setPhoneNumber("9876543210");
		admin.setIsActive(true);
		adminRepo.save(admin);
		assertNotNull(adminRepo.findById(3L).get());		
		
	}

	@Test
	void testGetUser() {
		userRepo.findById(1l);

	}

	@Test
	void testGetAllUser() {
		userRepo.findAll();
		
	}

	@Test
	void testGetUnApprovedQuestions() {
		List<Question> questionList = questionRepo.findByIsApproved();
	
	}
	@Test
	void testGetUnApprovedAnswers() {
		List<Answer> answerList = answerRepo.findByIsApproved();
	}

	@Test
	void testApproveQuestion() {
		Question question = questionRepo.findById(1L).get();
		question.setIsApproved(true);
		questionRepo.save(question);
		
	}

	@Test
	void testApproveAnswer() {
		Answer answer = answerRepo.findById(1L).get();
		answer.setIsApproved(true);
		answerRepo.save(answer);
		
	}

	@Test
	void testDeleteQuestion() {
		questionRepo.deleteById(1l);
	}

	@Test
	void testDeleteAnswer() {
		answerRepo.deleteById(1l);
		
	}

}
