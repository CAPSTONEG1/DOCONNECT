/*@Author:Prathamesh
Modified Date:30-08-2022
Description:Dto class of postanswer contains attributes like userId, questionId, answer and createdDate.
*/

package com.wipro.doconnect.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostAnswerDTO
{
	@NotNull(message = "Please provide User ID")
	private Long userId;
	
	@NotNull(message = "Please provide Question ID")
	private Long questionId;
	
	@NotBlank(message = "Answer is needed to submit")
	private String answer;
	
	private Date createdDate;

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
}
