package com.wipro.doconnect.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.doconnect.dto.AnswerDto;
import com.wipro.doconnect.entity.Answers;
import com.wipro.doconnect.entity.Status;

import java.util.List;

@Repository
public interface AnswerRepo extends JpaRepository<Answers,Long> {

    List<AnswerDto> findAllByStatus(Status status);
}
