package com.mySpring.springNote2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NoteDTO {

	private int id;
	private String writer;
	private String content;
}


