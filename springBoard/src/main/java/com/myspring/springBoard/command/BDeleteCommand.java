package com.myspring.springBoard.command;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.myspring.springBoard.dao.BDao;

public class BDeleteCommand implements BCommand{
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map =model.asMap();
		HttpServletRequest req =(HttpServletRequest)map.get("request");
		
		/*
		 * try { req.setCharacterEncoding("UTF-8"); } catch
		 * (UnsupportedEncodingException e) { e.printStackTrace(); }
		 */
		BDao dao =new BDao();
		String bId=req.getParameter("bId");	
		dao.delete(bId);
	}

}
