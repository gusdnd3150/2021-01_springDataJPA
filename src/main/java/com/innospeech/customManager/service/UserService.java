package com.innospeech.customManager.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.innospeech.customManager.model.Users;
import com.innospeech.customManager.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	// insert
	public void save(Users user) {
		repository.save(user);
	}
	
	// 전체 검색
	public Page<Users> list(Pageable pageable){
		return repository.findAll(pageable);
	}
	
	// 삭제하기
	public void delete(Users user) {
		repository.deleteById(user.getId());
	}
	
	// 가져오기
	public Optional<Users> select(Users user) {
		Optional<Users> u =null;
		u =repository.findById(user.getId());
		return u;
	}
	
}
