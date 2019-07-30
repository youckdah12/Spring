package com.mySpring.springNote3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.mySpring.springNote3.dto.NoteDTO;

public class NoteDAO {
	//servlet-context에서 자동 생성하여 객체를 주입
	private JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	//write
	public void write(final String writer, final String content){
		template.update(new PreparedStatementCreator() {		
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql= "insert into tblNote(id, writer, content) values(tblNoteSeq.nextval,?,?)";
				PreparedStatement pstmt =con.prepareStatement(sql);
				pstmt.setString(1, writer);
				pstmt.setString(2, content);
				return pstmt;
			}
		});
	}
	
	//list
	public ArrayList<NoteDTO> list(){
		String sql="select * from tblNote order by id desc";
		return (ArrayList<NoteDTO>)template.query(sql, new BeanPropertyRowMapper<NoteDTO>(NoteDTO.class));
	}
	
	//delete
	public void delete(final int id) {
		String sql="delete from tblNote where id=?";
		template.update(sql,new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, id);
				
			}
		});
	}
}
