package com.wipro.doconnect.chat.service;

import java.util.List;
import javax.validation.Valid;
import com.wipro.doconnect.chat.dto.MessageDTO;


public interface MessageService
{
	public MessageDTO sendMessage(@Valid MessageDTO messageDTO);
	public List<MessageDTO> getMessage();
}
