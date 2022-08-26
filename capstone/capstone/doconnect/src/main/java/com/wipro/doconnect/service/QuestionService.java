package com.wipro.doconnect.service;

import java.util.List;

import com.wipro.doconnect.dto.AnswerDto;

import com.wipro.doconnect.dto.QuestionDto;
import com.wipro.doconnect.dto.QuestionSearch;

import com.wipro.doconnect.response.GeneralResponse;

public interface QuestionService {

    String addQuestion( QuestionDto questionDto);

    List<QuestionDto> getAllQuestions();

    //SingleQuestionDto getQuestionById(Long id, Long userId);

    QuestionSearch searchQuestionByTitle(String title, int pageNum);

    GeneralResponse addAnswer(AnswerDto answerDto);

}

