package com.myspring.springNote.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.spi.DirStateFactory.Result;
import javax.sql.DataSource;

import com.myspring.springNote.dao.*;
import com.myspring.springNote.dto.NoteDTO;

public class NoteDAO {
	DataSource ds;
	
	public NoteDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Insert
	public void write(String writer, String content) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			String query = "insert into tblNote (id, writer, content) values (tblNoteSeq.nextval, ?, ?)";
			pstmt = con.prepareStatement(query);
		
			pstmt.setString(1, writer);
			pstmt.setString(2, content);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	//list
	public ArrayList<NoteDTO> list(){
		ArrayList<NoteDTO> dtos = new ArrayList<NoteDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con=ds.getConnection();
			String sql ="select * from tblNote order by id";
			pstmt =con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int Id =rs.getInt("id");
				String Writer =rs.getString("writer");
				String Content =rs.getString("content");
				
				NoteDTO dto= new NoteDTO(Id,Writer,Content);
				dtos.add(dto);
			}
		}catch(Exception e){
				e.printStackTrace();
			}finally {
				try {
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
					if (con != null)
						con.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
		}
		return dtos;
	}
	
	/*
	 * //contentView public NoteDTO contentView(String bId) { upHit(bId); Connection
	 * con = null; PreparedStatement pstmt = null; ResultSet rs = null; BDto dto=
	 * null; try { con=ds.getConnection(); String sql =
	 * "select * from tblBoard where bId = ?"; pstmt = con.prepareStatement(sql);
	 * pstmt.setInt(1,Integer.parseInt(bId)); rs = pstmt.executeQuery();
	 * if(rs.next()) { String bName =rs.getString("bName"); String bTitle
	 * =rs.getString("bTitle"); String bContent =rs.getString("bContent"); Timestamp
	 * bDate =rs.getTimestamp("bDate"); int bHit= rs.getInt("bHit"); dto= new
	 * BDto(Integer.parseInt(bId),bName,bTitle,bContent,bDate,bHit); }
	 * }catch(Exception e){ e.printStackTrace(); }finally { try { if (rs != null)
	 * rs.close(); if (pstmt != null) pstmt.close(); if (con != null) con.close(); }
	 * catch (Exception e2) { e2.printStackTrace(); } } return dto; }
	 */
	//modify
	/*
	 * public void modify(String bId, String bName, String bTitle, String bContent)
	 * { Connection con = null; PreparedStatement pstmt = null; try {
	 * con=ds.getConnection(); String sql =
	 * "update tblBoard set bName = ?, bTitle = ?, bContent = ? where bId = ?";
	 * pstmt =con.prepareStatement(sql); pstmt.setString(1, bName);
	 * pstmt.setString(2, bTitle); pstmt.setString(3, bContent); pstmt.setInt(4,
	 * Integer.parseInt(bId)); pstmt.executeUpdate(); }catch(Exception e){
	 * e.printStackTrace(); }finally { try { if (pstmt != null) pstmt.close(); if
	 * (con != null) con.close(); } catch (Exception e2) { e2.printStackTrace(); } }
	 * }
	 */
	//delete
	public void delete(String id) {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con=ds.getConnection();
				String 
				sql = "delete from tblNote where id = ?";
				pstmt =con.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(id));
				pstmt.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();			
			}finally {
				try {
					if (pstmt != null)
						pstmt.close();
					if (con != null)
						con.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
	}
	/*
	 * //upHit private void upHit(String bId) { Connection con = null;
	 * PreparedStatement pstmt = null; try { con=ds.getConnection(); String sql =
	 * "update tblBoard set bHit = bHit + 1 where bId = ?"; pstmt
	 * =con.prepareStatement(sql); pstmt.setInt(1, Integer.parseInt(bId));
	 * pstmt.executeUpdate(); }catch(Exception e){ e.printStackTrace(); }finally {
	 * try { if (pstmt != null) pstmt.close(); if (con != null) con.close(); } catch
	 * (Exception e2) { e2.printStackTrace(); } } }
	 */
}