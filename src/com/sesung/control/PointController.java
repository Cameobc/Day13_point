package com.sesung.control;

import java.util.ArrayList;
import java.util.Scanner;

import com.sesung.input.PointInput;
import com.sesung.point.PointDAO;
import com.sesung.point.PointDTO;
import com.sesung.view.PointView;

public class PointController {
	private Scanner sc;
	private PointDAO dao;
	private PointInput pi;
	private PointView pv;
	private PointDTO dto;

	public PointController() {
		sc = new Scanner(System.in);
		dao = new PointDAO();
		pi = new PointInput();
		pv = new PointView();
		dto = new PointDTO();
	}

	public void start() throws Exception {
		//1.정보추가, 2.정보삭제, 3.정보번호조회, 4.정보전체조회, 5.종료
		boolean check = true;
		ArrayList<PointDTO> ar = new ArrayList<PointDTO>();
		while(check) {
			System.out.println("1.정보추가");
			System.out.println("2.정보삭제");
			System.out.println("3.선택조회");
			System.out.println("4.전체조회");
			System.out.println("5.종     료");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				dto= pi.setPoint();
				int numb = dao.insertnum();
				dto.setNum(numb+1);
				ar.add(dto);
				int result = dao.insert(dto);
				String message = "추가실패";
				if(result>0) {
					message="추가성공";
				}
				pv.view(message);
				break;
			case 2:
				int num = pi.setNum("삭제");
				result = dao.delete(num);
				String message2 = "삭제실패";
				if(result>0) {
					message2 = "삭제완료";
				}
				pv.view(message2);
				break;
			case 3:
				num = pi.setNum("조회");
				dto = dao.selectOne(num);
				if(dto!=null) {
					pv.view(dto);
				}else {
					pv.view("없는 번호");
				}
				break;
			case 4: 
				ar = dao.selectList();
				pv.view(ar);
				break;
			case 5 :
				pv.view("프로그램 종료");
				check=!check;
				break;
			default:
				pv.view("잘못된 번호를 입력 하셨습니다.");
			}
		}

	}

}
