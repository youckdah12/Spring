package com.myspring.springBoard.command;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.myspring.springBoard.dao.BDao;
import com.myspring.springBoard.dto.BDto;

public class BContentCommand implements BCommand{

	@Override// MVC1 -> JSP,Bean,Msg
	// MVC2 -> model
	public void execute(Model model) {
		Map<String, Object> map =model.asMap();
		HttpServletRequest req =(HttpServletRequest)map.get("request");
		String bId=req.getParameter("bId");
		BDao dao =new BDao();
		BDto dto =dao.contentView(bId);
		model.addAttribute("contentView",dto);
	
	}
}

