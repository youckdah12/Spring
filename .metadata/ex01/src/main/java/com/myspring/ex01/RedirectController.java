package com.myspring.ex01;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {
	
	@RequestMapping(value="/studentConfirm")
	public String studentRedirect(HttpServletRequest req) {
		String id = req.getParameter("id");
		if(id.equals("aaa")) {
			return "redirect:studentOK";
		}
		return "redirect:studentNG";
	}
	
	@RequestMapping(value="/studentOK")
	public String studentOK(Model model) {
		return "student/studentOK";
	}

	@RequestMapping(value="/studentNG")
	public String studentNG(Model model) {
		return "student/studentNG";
	}
	
	@RequestMapping(value="studentURL")
	public String studentURL(Model model) {
		return "redirect:http://localhost/ex01/form.jsp";}
	
}
