package com.wipro.doconnect.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message
{
	@NotBlank(message = "Provide User Details")
	private String fromUser;
	
	@NotBlank(message = "Provide Message")
	private String message;

	public String getFromUser() {
		return fromUser;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
