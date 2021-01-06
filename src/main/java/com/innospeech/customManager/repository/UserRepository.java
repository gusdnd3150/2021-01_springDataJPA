package com.innospeech.customManager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.innospeech.customManager.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public void findByEmail(String name);
	
	
}
