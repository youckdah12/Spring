package com.myspring.springNote.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myspring.springNote.command.*;

@Controller
public class NoteController {
	NoteCommand command;
	
	@RequestMapping(value="/NoteForm")
	public String NoteForm(Model model) {
		return "NoteForm";
	}
	
	@RequestMapping(value="/NoteList")
	public String NoteList(Model model) {
		command =new NoteListCommand();
		command.execute(model);
		return "NoteList";
	}
	
	@RequestMapping(value="/writer")
	public String writer(HttpServletRequest req, Model model) {
		model.addAttribute("request",req);
		command =new NoteWriterCommand();
		command.execute(model);
		return "redirect:NoteList";
	}
	
	@RequestMapping(value="/delete")
	public String delete(HttpServletRequest req ,Model model) {
		model.addAttribute("request",req);
		command =new NoteDeleteCommand();
		command.execute(model);
		return "redirect:NoteList";
	
}
}
