package com.innospeech.customManager.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
@Component
public class UserDTO {

	private int id;
	private String name;
	private String email;
	private String password;
	private Date updateday;
	
}
