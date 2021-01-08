package com.innospeech.customManager.controller;

import java.util.Calendar;
import java.util.Optional;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.innospeech.customManager.dto.BoardDTO;
import com.innospeech.customManager.dto.UserDTO;
import com.innospeech.customManager.model.Board;
import com.innospeech.customManager.model.Users;
import com.innospeech.customManager.service.BoardService;
import com.innospeech.customManager.service.UserService;


@Controller
public class WebController {

	@Autowired
	private BoardService service;
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/login")
	public String lginform() {
		return "login";
	}
	
	
	@GetMapping("/logOut")
	public String logout(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "login";
	}
	
	@PostMapping("/userLogin")
	@ResponseBody
	public String login(UserDTO userDTO,HttpServletRequest request,HttpServletResponse response) {
		String result="";
		try {
			result= userService.checkPassword(userDTO,request);
		} catch (Exception e) {
			e.printStackTrace();
			result="fail";
		}
		return result;
	}

	
	//report 페이지이동
	@GetMapping("/report")
	public String report(Model model,
			@RequestParam(value="page",defaultValue="0") int page,
			@RequestParam(value="size",defaultValue="6") int size) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC,"boardnum"));
		Page<Board> list = service.list(pageable);
		
		model.addAttribute("reportList", list);
		model.addAttribute("maxPage", 6);
		return "reportBoard";
	}
	
	//메인화면
	@GetMapping("/main.do")
	public String view(Model model,
			@RequestParam(value="page",defaultValue="0") int page,
			@RequestParam(value="size",defaultValue="3") int size) {
		//BoardDTO dto= new BoardDTO();
		
		Page<Board> list = service.list(PageRequest.of(page, size));
		// board ,user 조인결과 + 페이징
		model.addAttribute("reportList", list);
		model.addAttribute("maxPage", 2);
		return "main";
	}
	
	// 업무보고 검색
	@GetMapping("/searchBoard")
	public String searchBoard(Model model,
			@RequestParam(value="page",defaultValue="0") int page,
			@RequestParam(value="size",defaultValue="3") int size,
			@RequestParam(value="seacrContent")String seacrContent) {
		
		Page<Board> list = service.searchList(seacrContent,PageRequest.of(page, size));
		
		model.addAttribute("reportList", list);
		model.addAttribute("maxPage", 2);
		return "reportBoard";
	}
	
	//게시판 등록
	@PostMapping("/insertBoard")
	@ResponseBody
	public String insert(Model model,BoardDTO boardDTO) {
		/*
		 * Calendar cal = Calendar.getInstance(); cal.to
		 */
		String result= "";
	    try {
	    	result =service.writeBoard(boardDTO);
		} catch (Exception e) {
			e.printStackTrace();
			result= "fail";
		}
		return result;
	}
	
	
   /*
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
	*/
}
