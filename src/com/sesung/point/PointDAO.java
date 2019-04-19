package com.sesung.point;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.sesung.util.DBConnector;

public class PointDAO {
	
	public int insertnum() throws Exception{
		Connection con = DBConnector.dbConnect();
//		String sql = "INSERT INTO POINT (NUM) VALUES (MAX(NUM)+1)";
		String sql = "Select nvl(MAX(NUM), 0) as num FROM POINT";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		int a = 0;
		if(rs.next()) {
			a = rs.getInt("num");
		}
//		rs.close();
//		st.close();
//		sql = "INSERT INTO POINT (NUM) VALUES (?)";
//		st = con.prepareStatement(sql);
//		st.setInt(1, a);
		DBConnector.disconnect(con, st, rs);
		return a;
	}
	
	public ArrayList<PointDTO> selectList() throws Exception{
		Connection con = DBConnector.dbConnect();
		String sql = "SELECT * FROM POINT ORDER BY NUM DESC";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		ArrayList<PointDTO> ar =new ArrayList<PointDTO>();
		while(rs.next()) {
			PointDTO dto = new PointDTO();
			dto.setNum(rs.getInt("num"));
			dto.setsId(rs.getString("sid"));
			dto.setKor(rs.getInt("kor"));
			dto.setEng(rs.getInt("eng"));
			dto.setMath(rs.getInt("math"));
			dto.setTotal(rs.getInt("total"));
			dto.setAvg(rs.getDouble("avg"));
			dto.setbNum(rs.getInt("bnum"));
			ar.add(dto);
		}
		DBConnector.disconnect(con, st, rs);
		return ar;
		
	}
	
	public PointDTO selectOne(int num) throws Exception{
//		Scanner sc = new Scanner(System.in);
		Connection con = DBConnector.dbConnect();
		String sql = "SELECT * FROM POINT WHERE NUM=?";
		PreparedStatement st = con.prepareStatement(sql);
//		System.out.println("조회할 번호를 입력하세요.");
		st.setInt(1, num);
		ResultSet rs = st.executeQuery();
		PointDTO dto = null;
		if(rs.next()) {
			dto = new PointDTO();
			dto.setNum(rs.getInt("num"));
			dto.setsId(rs.getString("sid"));
			dto.setKor(rs.getInt("kor"));
			dto.setEng(rs.getInt("eng"));
			dto.setMath(rs.getInt("math"));
			dto.setTotal(rs.getInt("total"));
			dto.setAvg(rs.getDouble("avg"));
			dto.setbNum(rs.getInt("bnum"));
		}
		
		DBConnector.disconnect(con, st, rs);
		return dto;
		
		
		
//		return result;
	}
	
	public int delete(int num) throws Exception {
		int result = 0;
//		Scanner sc = new Scanner(System.in);
		Connection con = DBConnector.dbConnect();
		String sql = "DELETE POINT WHERE NUM=?";
		PreparedStatement st = con.prepareStatement(sql);
//		System.out.println("지울번호 입력");
		st.setInt(1, num);
		result = st.executeUpdate();
		DBConnector.disconnect(con, st);
		return result;
	}
	

	public int insert(PointDTO dto) throws Exception{
		int result =0;
		//1.4가지정보, 2.드라이버 로딩, 3.연결, 4.SQL문 작성, 5.미리보내기, 6.?세팅, 7.최종전송후 결과처리 8.연결끊기
		Connection con = DBConnector.dbConnect();
		String sql = "INSERT INTO POINT VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, dto.getNum());
		st.setString(2, dto.getsId());
		st.setInt(3, dto.getKor());
		st.setInt(4, dto.getEng());
		st.setInt(5, dto.getMath());
		st.setInt(6, dto.getTotal());
		st.setDouble(7, dto.getAvg());
		st.setInt(8, dto.getbNum());
		result = st.executeUpdate();
		DBConnector.disconnect(con, st);
		return result;
	}
}
