package com.innospeech.customManager.service;

import java.util.List;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.innospeech.customManager.dto.UserDTO;
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
		return repository.findById(user.getId());
	}
	
	// 가져오기 email로
	public Users selectbyEmail(UserDTO userDTO) {
		return repository.findByEmail(userDTO.getEmail());
	}
	
	//로그인 체크
	public String checkPassword(UserDTO userDTO,HttpServletRequest request) {
		HttpSession session = request.getSession();
		Users selectUser= repository.findByEmail(userDTO.getEmail());
		String result="";
		
		if(selectUser==null) {
			result="userNull";	
		}else if(!selectUser.getPassword().equals(userDTO.getPassword())) { 
			result="dismachPassword";	
		}else {
			session.setAttribute("LOGIN", selectUser);
			result="success";
		}
		return result;
	}
	
	
}
