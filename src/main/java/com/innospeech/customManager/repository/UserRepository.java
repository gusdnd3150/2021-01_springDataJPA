package com.innospeech.customManager.repository;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.innospeech.customManager.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{
	
	public void findByEmail(String name);
	
	public Page<Users> findAll(Pageable pageable);
	
}
