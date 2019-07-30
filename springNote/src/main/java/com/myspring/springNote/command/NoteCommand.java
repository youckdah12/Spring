package com.myspring.springNote.command;

import org.springframework.ui.Model;

public interface NoteCommand {
	void execute(Model model);
}
