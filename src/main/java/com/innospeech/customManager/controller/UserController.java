package com.innospeech.customManager.controller;

import java.util.ArrayList;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.innospeech.customManager.dto.UserDTO;
import com.innospeech.customManager.model.Users;
import com.innospeech.customManager.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {
	
	@Autowired
	private UserService service;
	

	//회원가입
	@PostMapping("userJoin")
	@ResponseBody
	public String join(UserDTO dto) {
		String result ="fail";
		
		try {
			result= service.joinUser(dto);
			
		} catch (Exception e) {
			e.printStackTrace();
			result="fail";
		}
		
		return result;
	}
}
	
