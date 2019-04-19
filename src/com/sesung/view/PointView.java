package com.sesung.view;

import java.util.ArrayList;

import com.sesung.point.PointDTO;

public class PointView {

	public void view(ArrayList<PointDTO> ar) {
		for(PointDTO dto : ar) {
			this.view(dto);
		}
	}

	public void view(PointDTO dto) {
		System.out.println("학생 번호 : "+dto.getNum());
		System.out.println("학생 아이디 : "+dto.getsId());
		System.out.println("국어점수 : "+dto.getKor());
		System.out.println("영어점수 : "+dto.getEng());
		System.out.println("수학점수 : "+dto.getMath());
		System.out.println("점수합계 : "+dto.getTotal());
		System.out.println("평균 : "+dto.getAvg());
		System.out.println("반 번호 : "+dto.getbNum());
		System.out.println("==================");
	}

	public void view(String str) {
		System.out.println(str);
	}

}
