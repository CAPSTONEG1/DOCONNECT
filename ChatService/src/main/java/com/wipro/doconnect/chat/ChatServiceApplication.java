/*@Author:Rajesh
Modified Date:30-08-2022
Description:Main class for ChatService.
*/


package com.wipro.doconnect.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ChatServiceApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(ChatServiceApplication.class, args);
	}
}
