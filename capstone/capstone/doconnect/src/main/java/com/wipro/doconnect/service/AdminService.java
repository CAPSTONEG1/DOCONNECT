package com.wipro.doconnect.service;

import java.util.List;

import com.wipro.doconnect.dto.AnswerDto;
import com.wipro.doconnect.dto.AuthenticationRequest;
import com.wipro.doconnect.dto.QuestionDto;
import com.wipro.doconnect.dto.SignupRequest;
import com.wipro.doconnect.dto.UserDto;
import com.wipro.doconnect.response.GeneralResponse;

public interface AdminService {

    UserDto createAdmin(SignupRequest signupRequest);

    Boolean hasUserWithEmail(String email);

    GeneralResponse login(AuthenticationRequest authenticationRequest);

    List<QuestionDto> getAllQuestions();

    GeneralResponse approveAnswer(Long id);

    GeneralResponse approveQuestion(Long id);

    public void deleteQuestion(Long id);

    public void deleteAnswer(Long id);

    List<AnswerDto> getAllAnswers();

}

