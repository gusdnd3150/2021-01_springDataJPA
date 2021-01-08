package com.innospeech.customManager.dto;



import java.util.Date;

import org.springframework.stereotype.Component;

import com.innospeech.customManager.model.Board;

import org.springframework.data.jpa.domain.Specification;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class BoardDTO {
	private int boardnum;
	
	private String title;
	private String content;
	private Date updateday;
	private String boardtype;
	private String searchType;
	private String searchContent;
    private int id;
    
   // 제목 like 검색
	public Specification<Board> titleLike(String title) {
		  return BoardSpecification.titleLike(title) ;
    }
}
