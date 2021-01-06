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

import com.innospeech.customManager.model.Users;
import com.innospeech.customManager.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {
	
	@Autowired
	private UserService service;
	
	/*
	 * @DeleteMapping
	 * 
	 * @PutMapping
	 */
	
	@GetMapping("/main.do")
	public String view(Model model,
			@RequestParam(value="page",defaultValue="0") int page,
			@RequestParam(value="size",defaultValue="3") int size) {
		Page<Users> list = service.list(PageRequest.of(page, size));
		
		model.addAttribute("userList", list);
		model.addAttribute("maxPage", 2);
		return "main";
	}
	
	
	@PostMapping("/insertBoard")
	@ResponseBody
	public String insert(Model model,Users user) {
		String result= "";
	    try {
	    	service.save(user);
	    	result= "success";
		} catch (Exception e) {
			e.printStackTrace();
			result= "fail";
		}
		return result;
	}
	
	@PostMapping("/deleteBoard")
	@ResponseBody
	public String delete(Users user) {
		String result= "";
	    try {
	    	service.delete(user);
	    	result= "success";
		} catch (Exception e) {
			e.printStackTrace();
			result= "fail";
		}
		return result;
	}
	
	
	@GetMapping("/selectBoard")
	@ResponseBody
	public Optional<Users> select(Users user) {
		Optional<Users> selectUser=null;
		try {
			selectUser =service.select(user);
			
		} catch (Exception e) {
		}
		return selectUser;
	}
	
	@PutMapping("/updateBoard")
	@ResponseBody
	public String update(Users user) {
		log.info(user.toString());
		
		String result= "";
	    try {
	    	service.save(user);
	    	result= "success";
		} catch (Exception e) {
			e.printStackTrace();
			result= "fail";
		}
		return result;
	}
}
	
