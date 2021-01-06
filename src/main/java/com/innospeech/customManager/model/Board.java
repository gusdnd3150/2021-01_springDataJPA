package com.innospeech.customManager.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Data
@ToString(exclude ="users")
@Entity
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int boardnum;
	
	@Column
	private String title;
	
	@Column
	private String content;
	
	@Column
	private Date updateday;
	
	@ManyToOne
    @JoinColumn(name="id")
    private Users user;
	
	
}
