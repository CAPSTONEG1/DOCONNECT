/*@Author:Rajesh
Modified Date:30-08-2022
Description:Main class where the flow of execution starts.
*/
package com.wipro.doconnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;



@SpringBootApplication
@EnableEurekaClient
@OpenAPIDefinition(info=@Info(title="DOCONNECT API", version = "1.0", description = "Question And Answers App"))
public class DoConnectApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(DoConnectApplication.class, args);
	}
	
	@Bean
	RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
}