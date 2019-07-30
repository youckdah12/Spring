package com.myspring.ex01.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*@Getter
@Setter
@ToString*/
@Data

//DTO : Date Transfer Object
public class MemberDto {

	private String id;
	private String pwd;
	private String name;
	private String email;
		 
	/*
	 * public String getId() { return id; } public void setId(String id) { this.id =
	 * id; } public String getPwd() { return pwd; } public void setPwd(String pwd) {
	 * this.pwd = pwd; } public String getName() { return name; } public void
	 * setName(String name) { this.name = name; } public String getEmail() { return
	 * email; } public void setEmail(String email) { this.email = email; }
	 */
	
}
