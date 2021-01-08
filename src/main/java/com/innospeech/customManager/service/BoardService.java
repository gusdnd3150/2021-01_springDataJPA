package com.innospeech.customManager.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.innospeech.customManager.dto.BoardDTO;
import com.innospeech.customManager.dto.BoardSpecification;
import com.innospeech.customManager.dto.UserDTO;
import com.innospeech.customManager.model.Board;
import com.innospeech.customManager.model.Users;
import com.innospeech.customManager.repository.BoardRepository;
import com.innospeech.customManager.repository.UserRepository;
import org.springframework.data.jpa.domain.Specification;


@Service
public class BoardService {
	@Autowired
	private BoardRepository repository;
	@Autowired
	private UserRepository userRepository;
	
	    // 전체 검색
		public Page<Board> list(Pageable pageable){
			return repository.findAll(pageable);
		}
		
		
		public Page<Board> findByBoardDTO(BoardDTO dto, Pageable pageable){
			Specification<Board> spec = Specification.where(BoardSpecification.titleLike(dto.getTitle()));
			/*
			if (category != null) {
			     spec = spec.and(ContentSpecs.category(category));
			}*/
			Page<Board> list = repository.findAll(spec,pageable);
			return list;
		};
		
		//검색  (이름,제목)
		public Page<Board> searchList(String searchContent,Pageable pageable){
			Specification<Board> spec = Specification.where(BoardSpecification.titleLike(searchContent))
					.or(BoardSpecification.contentLike(searchContent));
			Page<Board> list=repository.findAll(spec,pageable);
			
			return list;
		};
		
		public void save(Board board) {
			repository.save(board);
		}
		
		// 게시글 등록
		public String writeBoard(BoardDTO boardDTO) {
			String result ="success";
			
			try {
				Users user = userRepository.findById(boardDTO.getId());
				Board board = Board.createBoard(user, boardDTO);
				repository.save(board);
			} catch (Exception e) {
				e.printStackTrace();
				result="fail";
			}
			return result;
		}
	
}
