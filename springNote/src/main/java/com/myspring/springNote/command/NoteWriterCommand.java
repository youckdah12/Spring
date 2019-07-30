package com.myspring.springNote.command;


	

	import java.io.UnsupportedEncodingException;
	import java.util.Map;

	import javax.servlet.http.HttpServletRequest;

	import org.springframework.ui.Model;

	import com.myspring.springNote.dao.*;

	public class NoteWriterCommand implements NoteCommand{ 
		
		@Override
		public void execute(Model model) {
			Map<String, Object> map =model.asMap();
			HttpServletRequest req =(HttpServletRequest)map.get("request");
			try {
				req.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
			String writer =req.getParameter("writer");
			String content =req.getParameter("content");
			NoteDAO dao =new NoteDAO();
			dao.write(writer,content);
		}

	}


