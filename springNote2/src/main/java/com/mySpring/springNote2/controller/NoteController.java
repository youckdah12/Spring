package com.mySpring.springNote2.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mySpring.springNote2.dao.INoteDAO;

@Controller
public class NoteController {
	
	@Autowired
	private SqlSession sqlSession;//변수 명은 servlet-context.xml에 있는 id와 같아야함
	
	@RequestMapping(value="/list")
	public String list(Model model) {
		INoteDAO dao = sqlSession.getMapper(INoteDAO.class);
		model.addAttribute("list",dao.listDAO());
		return	"noteList";
	}

	@RequestMapping(value="/form")
	public String noteForm(Model model) {
		return "noteForm"; //views/noteForm.jsp 실행
	}
	
	@RequestMapping(value="/write")
	public String write(HttpServletRequest req, Model model) {
		INoteDAO dao = sqlSession.getMapper(INoteDAO.class);
		dao.writeDAO(req.getParameter("writer"), req.getParameter("content"));
		return "redirect:list";
	}
	
	@RequestMapping(value="/delete")
	public String delete(HttpServletRequest req, Model model) {
		INoteDAO dao = sqlSession.getMapper(INoteDAO.class);
		dao.deleteDAO(req.getParameter("id"));
		return "redirect:list";
	}
}
