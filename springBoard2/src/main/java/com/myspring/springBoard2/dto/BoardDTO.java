package com.myspring.springBoard2.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BoardDTO {
	
	private int id;
	private String name;
	private String title;
	private String content;
	private Timestamp regdate;
	private int hit;
	
}
