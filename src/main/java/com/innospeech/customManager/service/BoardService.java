package com.innospeech.customManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.innospeech.customManager.model.Board;
import com.innospeech.customManager.repository.BoardRepository;

@Service
public class BoardService {
	@Autowired
	private BoardRepository repository;
	
	
	    // 전체 검색
		public Page<Board> list(Pageable pageable){
			return repository.findAll(pageable);
		}
		
		public void save(Board board) {
			repository.save(board);
		}
	
}
