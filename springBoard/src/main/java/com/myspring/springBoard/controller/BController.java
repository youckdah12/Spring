package com.myspring.springBoard.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myspring.springBoard.command.BCommand;
import com.myspring.springBoard.command.BContentCommand;
import com.myspring.springBoard.command.BDeleteCommand;
import com.myspring.springBoard.command.BListCommand;
import com.myspring.springBoard.command.BModifyCommand;
import com.myspring.springBoard.command.BWriteCommand;

@Controller
public class BController {
	
	BCommand command;
	@RequestMapping(value="/writeView")
	public String wirteView(Model model) {
		return "writeView";//src/main/WEB-INF/views/writeView
	}
	
	@RequestMapping(value="/list")
	public String list(Model model) {
		command =new BListCommand();
		command.execute(model);
		return "list";
	}
	
	@RequestMapping(value="/write")
	public String write(HttpServletRequest req, Model model) {
		model.addAttribute("request",req);
		command =new BWriteCommand();
		command.execute(model);
		return "redirect:list";
	}
	
	@RequestMapping(value="/contentView")
	public String contentView(HttpServletRequest req ,Model model) {
		model.addAttribute("request",req);
		command =new BContentCommand();
		command.execute(model);
		return "contentView";
		
	}
	//6월25 일 수정 및 삭제
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(HttpServletRequest req ,Model model) {
		model.addAttribute("request",req);
		command =new BModifyCommand();
		command.execute(model);
		return "redirect:list";
		
	}
	
	@RequestMapping(value="/delete")
	public String delete(HttpServletRequest req ,Model model) {
		model.addAttribute("request",req);
		command =new BDeleteCommand();
		command.execute(model);
		return "redirect:list";
		
	}

}
