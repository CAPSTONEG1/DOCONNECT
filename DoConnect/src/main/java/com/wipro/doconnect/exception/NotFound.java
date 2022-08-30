/*@Author:Sumanth
Modified Date:30-08-2022
Description:Exception class to handle NotFound exception.
*/


package com.wipro.doconnect.exception;

//@NoArgsConstructor
//@AllArgsConstructor
public class NotFound extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	
	public NotFound() {
		// TODO Auto-generated constructor stub
	}

	public NotFound(String errorMsg) {
		super();
		this.errorMsg = errorMsg;
	}

	@SuppressWarnings("unused")
	private String errorMsg;

}
