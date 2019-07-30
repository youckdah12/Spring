package com.myspring.ex01;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.ex01.dto.MemberDto;

@Controller
public class MemberController {
	
	@RequestMapping("member/loginForm")
	public String loginForm() {
		return "member/loginForm";
	}
	
	@RequestMapping("member/confirmId")
	public String confirmId(HttpServletRequest req, Model model) {
		String id =req.getParameter("id");
		String pwd = req.getParameter("pwd");
		model.addAttribute("id", id);
		model.addAttribute("pwd",pwd);
		
		return "member/confirmId";
	}
	
	@RequestMapping("member/confirmId1")
	public String confirmId1(@RequestParam("id") String id , @RequestParam("pwd") String pwd,Model model) {
		model.addAttribute("id", id);
		model.addAttribute("pwd",pwd);
		
		return "member/confirmId";
	}

	@RequestMapping("member/joinForm")
	public String joinForm() {
		return "member/joinForm";
	}
	
	/*
	 * @RequestMapping("member/join") 
	 * public String join(@RequestParam("id") Stringid,@RequestParam("pwd") String pwd,@RequestParam("name") Stringname,@RequestParam("email") String email,Model model) { 
	 * MemberDto member =newMemberDto();
	 * member.setId(id); 
	 * member.setPwd(pwd); 
	 * member.setName(name);
	 * member.setEmail(email); 
	 * model.addAttribute("member", member); 
	 * return "member/join"; }
	 */
	
	@RequestMapping("member/join")//데이터 커맨드 객체
	//1.JSP에서 memberDTO 가져온다.
	//model.addAttribute("memberDto",member);
	//2.@ModelAttribute("member") 변수명 수정 가능
	public String join(@ModelAttribute("member") MemberDto member) {
		return "member/join";
	}
	
	//1.URL유동적을 호출
	//2.변수명 노출 부담 줄이기
	@RequestMapping("member/student/{studentId}/{no}")
	public String student(@PathVariable String studentId, @PathVariable int no, Model model) {
		model.addAttribute("studentId", studentId);
		model.addAttribute("no", no);
		return "member/student";
	}
	
	@RequestMapping("member/getPostForm")
	public String getPostForm() {
		//WEB-INF/views/member/getPodtForm.jsp를 호출
		return "member/getPostForm";
	}
	
	
	@RequestMapping(value="member/goGet", method=RequestMethod.GET)
	public String goStudent(HttpServletRequest req, Model model) {
		String id=req.getParameter("id");
		model.addAttribute("id",id);
		return "member/goGet";
	}
	
	@RequestMapping(value="member/goPost", method=RequestMethod.POST)
	//ModelAndView : Model(데이터)과 View를 동시에 설정가능
	public ModelAndView goStudent( HttpServletRequest req){
		ModelAndView mv =new ModelAndView();
		String id= req.getParameter("id");
		mv.addObject("id", id);
		mv.setViewName("member/goGet");
		return mv;
	}
}
