package com.innospeech.customManager.repository;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
//import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.innospeech.customManager.dto.BoardDTO;
import com.innospeech.customManager.model.Board;
import com.innospeech.customManager.model.Users;


@Repository
public interface BoardRepository extends JpaRepository<Board,Integer> ,JpaSpecificationExecutor<Board>{
	public Page<Board> findAll(Pageable pageable);
	
	Page<Board> findAll(Specification<Board> spec, Pageable pageable);
	
	
	
	
}
