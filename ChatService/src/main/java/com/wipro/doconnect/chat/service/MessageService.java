/*@Author:Sumanth
Modified Date:30-08-2022
Description:MessageService interface to perform message operations.
*/

package com.wipro.doconnect.chat.service;

import java.util.List;
import javax.validation.Valid;
import com.wipro.doconnect.chat.dto.MessageDTO;


public interface MessageService
{
	public MessageDTO sendMessage(@Valid MessageDTO messageDTO);
	public List<MessageDTO> getMessage();
}
