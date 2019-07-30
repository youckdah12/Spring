package com.mySpring.springNote3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mySpring.springNote3.dao.NoteDAO;

@Controller
public class NoteController {
	
	private NoteDAO dao;
	
	@Autowired
	public void setDao(NoteDAO dao) {
		this.dao =dao;
	}
	
	@RequestMapping(value="/form")
	public String noteForm(Model model) {
		return "noteForm";
	}
	@RequestMapping(value="/list")
	public String list(Model model) {
		model.addAttribute("list", dao.list());
		return "noteList";
	}
	
	@RequestMapping(value="/write")
	public String write(String writer, String content) {
		dao.write(writer, content);
		return "redirect:list";
	}
	
	@RequestMapping(value="/delete")
	public String delete(String id){
		dao.delete(Integer.parseInt(id));
		return "redirect:list";
	}
}
