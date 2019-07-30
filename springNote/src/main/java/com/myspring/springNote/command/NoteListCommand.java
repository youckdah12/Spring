package com.myspring.springNote.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.myspring.springNote.dao.*;
import com.myspring.springNote.dto.*;

public class NoteListCommand implements NoteCommand{
	
	@Override
	public void execute(Model model) {
		NoteDAO dao = new NoteDAO();
		ArrayList<NoteDTO> dtos = dao.list();
		model.addAttribute("NoteList",dtos);
	}

}
