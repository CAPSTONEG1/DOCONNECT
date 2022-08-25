package com.wipro.doconnect.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.doconnect.entity.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {

    Admin findFirstByEmail(String email);

    Optional<Admin> findByEmail(String email);
}