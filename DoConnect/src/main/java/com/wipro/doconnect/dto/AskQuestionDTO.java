/*@Author:Prathamesh
Modified Date:30-08-2022
Description:Dto class of AskQuestion contains question attributes.
*/

package com.wipro.doconnect.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//@Data
@NoArgsConstructor
@AllArgsConstructor
public class AskQuestionDTO
{
	@NotNull(message = "Please Provide the ID")
	private Long userId;
	
	@NotBlank(message = "Question required")
	private String question;
	
	@NotBlank(message = "Please provide the topic")
	private String topic;
	
	private Date createdDate;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	

}
