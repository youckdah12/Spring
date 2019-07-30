package com.myspring.springBoard2.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myspring.springBoard2.dao.mapper.*;
import com.myspring.springBoard2.dao.IBoardDAO;
import com.myspring.springBoard2.dao.*;

@Controller
public class BoardController {

	@Autowired//주입 이라는 뜻을가진 것-- DB연결 끝
	private SqlSession sqlSession; 
	
	@RequestMapping(value="/list")
	public String NoteList(Model model) {
		IBoardDAO dao =sqlSession.getMapper(IBoardDAO.class);
		model.addAttribute("list", dao.listDAO());
		return "list";//views/NoteList.jsp  실행
	}
	
	@RequestMapping(value = "/writeView")
	public String writeView(Model model) {
		return "writeView";//views/NoteForm.jsp  실행
	}
	
	@RequestMapping(value = "/write")
	public String write(HttpServletRequest req, Model model) {
		IBoardDAO dao =sqlSession.getMapper(IBoardDAO.class);
		dao.writeDAO(req.getParameter("name"),req.getParameter("title"),req.getParameter("content"));
		return "redirect:list";
	}
	
	@RequestMapping(value="/contentView")
	public String contentView(HttpServletRequest req ,Model model) {
		IBoardDAO dao =sqlSession.getMapper(IBoardDAO.class);
		model.addAttribute("contentView", dao.contentViewDAO(req.getParameter("id")));
		dao.uphitDAO(Integer.parseInt(req.getParameter("id")));
		return "contentView";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(HttpServletRequest req ,Model model) {
		IBoardDAO dao =sqlSession.getMapper(IBoardDAO.class);
		dao.modifyDAO(req.getParameter("id"), req.getParameter("name"), req.getParameter("title"), req.getParameter("content"));
		return "redirect:list";
	}
	
	@RequestMapping(value="/delete")
	public String delete(HttpServletRequest req ,Model model) {
		IBoardDAO dao =sqlSession.getMapper(IBoardDAO.class);
		dao.deleteDAO(req.getParameter("id"));
		return "redirect:list";
	}
}
