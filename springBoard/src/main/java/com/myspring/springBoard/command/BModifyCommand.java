package com.myspring.springBoard.command;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.myspring.springBoard.dao.BDao;

public class BModifyCommand implements BCommand{
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map =model.asMap();
		HttpServletRequest req =(HttpServletRequest)map.get("request");
		/*
		 * try { req.setCharacterEncoding("UTF-8"); } catch
		 * (UnsupportedEncodingException e) { e.printStackTrace(); }
		 */
		String bId =req.getParameter("bId");
		String bName =req.getParameter("bName");
		String bTitle =req.getParameter("bTitle");
		String bContent =req.getParameter("bContent");
		BDao dao =new BDao();
		dao.modify(bId,bName,bTitle,bContent);
	}

}
