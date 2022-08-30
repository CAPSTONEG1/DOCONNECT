/*@Author:Chakradhar
Modified Date:30-08-2022
Description:User Repository class.
*/

package com.wipro.doconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wipro.doconnect.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
	public User findByEmail(String email);
}
