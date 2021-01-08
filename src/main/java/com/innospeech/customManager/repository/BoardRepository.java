package com.innospeech.customManager.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.innospeech.customManager.model.Board;
import com.innospeech.customManager.model.Users;

@Repository
public interface BoardRepository extends JpaRepository<Board,Integer> {
	public Page<Board> findAll(Pageable pageable);
}
