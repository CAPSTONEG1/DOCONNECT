/*@Author:Sumanth
Modified Date:30-08-2022
Description:MessageServiceImpl implementation class that implements MessageService methods.
*/

package com.wipro.doconnect.chat.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.doconnect.chat.dto.MessageDTO;
import com.wipro.doconnect.chat.entity.Message;
import com.wipro.doconnect.chat.repository.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService {
	@Autowired
	private MessageRepository messageRepository;

	/*@Author:Sumanth
	Modified Date:30-08-2022
	Description:sendmessage service.
	Params:messageDTO
	ReturnType:MessageDTO
	*/
	@Override
	public MessageDTO sendMessage(@Valid MessageDTO messageDTO) {
		Message message = new Message();
		message.setMessage(messageDTO.getMessage());
		message.setFromUser(messageDTO.getFromUser());
		message = messageRepository.save(message);

		messageDTO.setFromUser(message.getFromUser());
		messageDTO.setMessage(message.getMessage());

		return messageDTO;
	}
	
	/*@Author:Sumanth
	Modified Date:30-08-2022
	Description:getMessage service.
	ReturnType:List
	*/
	@Override
	public List<MessageDTO> getMessage() {
		List<MessageDTO> data = new ArrayList<MessageDTO>();

		List<Message> messages = messageRepository.findAll();
		for (Message message : messages) {

			MessageDTO messageDTO = new MessageDTO();
			messageDTO.setFromUser(message.getFromUser());
			messageDTO.setMessage(message.getMessage());
			data.add(messageDTO);

		}

		return data;
	}
}
