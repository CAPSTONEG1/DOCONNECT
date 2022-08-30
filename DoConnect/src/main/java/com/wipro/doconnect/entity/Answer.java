/*@Author:RamyaSri
Modified Date:30-08-2022
Description:Entity class of answer contains entities like id, answer(which stores the answer query), answerUser(who posted answer), 
question(question query), isApproved(checks if answer is approved by admin or not), createdDate(answered date).
*/

package com.wipro.doconnect.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@Data
@NoArgsConstructor
@AllArgsConstructor
public class Answer
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "mention the answer")
	private String answer;
	
	@OneToOne
	private User answerUser;
	
	@OneToOne
	private Question question;
	private Boolean isApproved = false;
	private Date createdDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public User getAnswerUser() {
		return answerUser;
	}
	public void setAnswerUser(User answerUser) {
		this.answerUser = answerUser;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public Boolean getIsApproved() {
		return isApproved;
	}
	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	

}
