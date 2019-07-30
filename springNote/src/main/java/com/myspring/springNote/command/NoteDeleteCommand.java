package com.myspring.springNote.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.myspring.springNote.dao.*;

public class NoteDeleteCommand implements NoteCommand{
	@Override
	public void execute(Model model) {
		Map<String, Object> map =model.asMap();
		HttpServletRequest req =(HttpServletRequest)map.get("request");
		
		/*
		 * try { req.setCharacterEncoding("UTF-8"); } catch
		 * (UnsupportedEncodingException e) { e.printStackTrace(); }
		 */
		NoteDAO dao =new NoteDAO();
		String id= req.getParameter("id");	
		dao.delete(id);
	}
}

