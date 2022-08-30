/*@Author:Rajesh
Modified Date:30-08-2022
Description:Admin Repository class
*/

package com.wipro.doconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.doconnect.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>
{
	public Admin findByEmail(String email);
}
