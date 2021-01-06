package com.innospeech.customManager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innospeech.customManager.model.User;
import com.innospeech.customManager.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	// insert
	public void save(User user) {
		repository.save(user);
	}
	
	// 전체 검색
	public List<User> list(){
		return repository.findAll();
	}
	
	// 삭제하기
	public void delete(User user) {
		repository.deleteById(user.getId());
	}
	
	// 가져오기
	public Optional<User> select(User user) {
		Optional<User> u =null;
		u =repository.findById(user.getId());
		return u;
	}
	
}
