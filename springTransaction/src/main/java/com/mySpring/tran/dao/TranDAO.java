package com.mySpring.tran.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.mySpring.tran.dto.TranDTO;

public class TranDAO {
	private JdbcTemplate template;
	private PlatformTransactionManager transactionManager;
	
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	//servlet-context에서 자동 생성하여 객체를 주입
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	public int buyTicket(final TranDTO dto, int result) {
		TransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus status= transactionManager.getTransaction(definition);
		try {
			//card 입력
			template.update(new PreparedStatementCreator(){		
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					String sql ="insert into tblCard values(?,?)";
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(1, dto.getConsumerId());
					pstmt.setInt(2, dto.getAmount());
					return pstmt;
				}
			});
			//ticket입력
			template.update(new PreparedStatementCreator(){		
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					String sql ="insert into tblTicket values(?,?)";
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(1, dto.getConsumerId());
					pstmt.setInt(2, dto.getAmount());
					return pstmt;
				}
			});
			transactionManager.commit(status);
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
			transactionManager.rollback(status);
			return result;
		}
		return result;
	}//buyTicket
	
	
}
