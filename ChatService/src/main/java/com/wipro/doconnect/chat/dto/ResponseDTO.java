/*@Author:Prathamesh
Modified Date:30-08-2022
Description:DTO class for response.
*/

package com.wipro.doconnect.chat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO
{
	private String response;

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
	
}
