package com.innospeech.customManager.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.innospeech.customManager.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{
	
	
	
	public Users findByEmail(String email);
	public Page<Users> findAll(Pageable pageable);
	
}
