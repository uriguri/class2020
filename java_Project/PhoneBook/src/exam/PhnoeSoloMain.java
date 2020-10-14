package exam;

import java.util.Scanner;

public class PhnoeSoloMain {
/*
 	2020 10 14
 	ver01과 ver02를 순서대로 새로 코딩함
 	
 	잘못한 부분
 	
 	- 생성자와 출력메소드를 한번에 구성하려했엇음 (PhoneSolo)
 	    -> 다시 확인하고 분리해서 이해완료.
 	    
 	- PhoneSolo pSolo = null; 값을 생각하지 못함.
 		-> 참조변수는 null이다 참조변수는 null이다 참조변수는 null이다.
 		
 	- 출력이 되지않아 확인해보니 출력메소드가 While밖에 나와있엇음.
 		-> 블럭을 잘 확인하고 넣자
 	
 
 
 */
	public static void main(String[] args) {
		
		//입력받는 스캐너
		Scanner sc = new Scanner(System.in);
		
	//프로그램 실행계속
		
	while(true) {
		
		//입력받을 데이터를 설명
		System.out.println("전화번호부 입력을 시작합니다.");
		System.out.println("이름을 입력해주세요.");
		String name = sc.nextLine();
		System.out.println("번호를 입력해주세요.");
		String phoneNumber = sc.nextLine();
		System.out.println("생일을 입력해주세요.");
		String birthday = sc.nextLine();
		
		PhoneSolo pSolo = null;
		
		if(birthday.trim().isEmpty()) {
			pSolo = new PhoneSolo(name,phoneNumber,null);
		} else {
			pSolo = new PhoneSolo(name,phoneNumber,birthday);
		}
	
		//출력 메소드 사용
		pSolo.showSolo();
	}
	
	}
}