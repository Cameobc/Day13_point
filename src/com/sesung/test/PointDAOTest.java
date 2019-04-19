package com.sesung.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

import com.sesung.point.PointDAO;
import com.sesung.point.PointDTO;

public class PointDAOTest {
	
	@Test
	public void test() throws Exception {
		PointDAO pointDAO = new PointDAO();
		Random random = new Random();
		for(int i=0; i<100; i++) {
			PointDTO pointDTO = new PointDTO();
			int num = pointDAO.insertnum();
			pointDTO.setNum(num+1);
			pointDTO.setsId("iu"+i);
			pointDTO.setKor(random.nextInt(101));
			pointDTO.setEng(random.nextInt(101));
			int result = pointDAO.insert(pointDTO);
		}
		
		
		
//		PointDAO pa = new PointDAO();
//		pa.insertnum();
//		ArrayList<PointDTO> ar = pa.selectList();
//		assertNotEquals(0, ar.size());
//		assertEquals(3, ar.size());
		
	}
	
	
//	@Test
//	public void testselect() throws Exception {
//		PointDAO pa = new PointDAO();
//		PointDTO dto = new PointDTO();
//		dto= pa.selectOne(2);
//		assertNotNull(dto);
//	}

//	@Test
//	public void test() throws Exception {
//		PointDAO pa = new PointDAO();
//		PointDTO dto = new PointDTO();
//		int result = pa.insert(dto);
//		assertEquals(1, result);
//	}
	
//	@Test
//	public void deletetest() throws Exception {
//		PointDAO pa = new PointDAO();
//		int result = pa.delete(0);
//		assertEquals(1, result);
//	}

}
