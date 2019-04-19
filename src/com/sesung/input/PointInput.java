package com.sesung.input;

import java.util.Scanner;

import com.sesung.point.PointDTO;

public class PointInput {
	private Scanner sc;
	
	public PointInput() {
		sc = new Scanner(System.in);
	}
	
	public PointDTO setPoint() {
		PointDTO dto = new PointDTO();
//		System.out.println("NUM");
//		dto.setNum(sc.nextInt());
		System.out.println("SID");
		dto.setsId(sc.next());
		System.out.println("KOR");
		int kor = sc.nextInt();
		dto.setKor(kor);
		System.out.println("ENG");
		int eng = sc.nextInt();
		dto.setEng(eng);
		System.out.println("MATH");
		int math = sc.nextInt();
		dto.setMath(math);
		dto.setTotal(kor+eng+math);
		dto.setAvg((kor+eng+math)/3.0);
		System.out.println("BNUM");
		dto.setbNum(sc.nextInt());
		return dto;
	}
	
	
	public int setNum(String str) {
		System.out.println(str+"번호를 입력하세요.");
		int result = sc.nextInt();
		return result;
	}
	

}
