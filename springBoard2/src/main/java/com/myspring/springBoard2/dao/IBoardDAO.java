package com.myspring.springBoard2.dao;

import java.util.ArrayList;

import com.myspring.springBoard2.dto.BoardDTO;

public interface IBoardDAO {
	
	public ArrayList<BoardDTO> listDAO();
	public void writeDAO(String name , String title, String content);
	public BoardDTO contentViewDAO(String id);
	public void modifyDAO(String id, String name , String title, String content);
	public void deleteDAO(String id);
	public void uphitDAO(int id);
}