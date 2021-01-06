package com.innospeech.customManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.innospeech.customManager.model.Board;

public interface BoardRepository extends JpaRepository<Board,Integer> {

}
