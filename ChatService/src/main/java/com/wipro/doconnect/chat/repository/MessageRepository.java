/*@Author:Chakradhar
Modified Date:30-08-2022
Description:MessageRepository class.
*/

package com.wipro.doconnect.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wipro.doconnect.chat.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>
{

}
