package com.mySpring.tran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mySpring.tran.dao.TranDAO;
import com.mySpring.tran.dto.TranDTO;

@Controller
public class TranController {
	
	private TranDAO dao;
	
	@Autowired
	public void setDao(TranDAO dao) {
		this.dao=dao;
	}
	
	@RequestMapping(value="buy_ticket")
	public String buy_ticket() {
		return "buy_ticket";
	}
	
	@RequestMapping(value="buy_ticket_card")
	public String buy_ticket_card(TranDTO dto, Model model) {
		dao.buyTicket(dto, 0);
		model.addAttribute("ticketInfo", dto);
		return "buy_ticket_end";
	}
}
