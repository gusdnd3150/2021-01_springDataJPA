package com.innospeech.customManager.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.innospeech.customManager.dto.UserDTO;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Entity
@ToString(exclude ="users")
@Data
public class Users {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String password;
	
	@OneToMany(mappedBy = "user")
    private List<Board> board = new ArrayList<Board>();
	
	
	public Users() {};
	public Users(int id,String name,String email,String password) {
		this.id=id;
		this.name=name;
		this.email=email;
		this.password=password;
	};
	
	public static Users createUser(UserDTO dto)  {
		return new Users(dto.getId(),dto.getName(),dto.getEmail(),dto.getPassword());
	}
}

