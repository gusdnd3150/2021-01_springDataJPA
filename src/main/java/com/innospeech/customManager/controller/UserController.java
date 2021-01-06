package com.innospeech.customManager.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.innospeech.customManager.model.User;
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
	public String view(Model model) {
		
		List<User> list = new ArrayList<User>();
		list = service.list();
		
		model.addAttribute("userList", list);
		return "main";
	}
	
	
	@PostMapping("/insertBoard")
	@ResponseBody
	public String insert(Model model,User user) {
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
	public String delete(User user) {
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
	public Optional<User> select(User user) {
		Optional<User> selectUser=null;
		try {
			selectUser =service.select(user);
			
		} catch (Exception e) {
		}
		return selectUser;
	}
	
	@PutMapping("/updateBoard")
	@ResponseBody
	public String update(User user) {
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
	
