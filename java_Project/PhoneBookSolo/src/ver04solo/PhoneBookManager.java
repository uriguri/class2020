package ver04solo;

import java.util.Scanner;

public class PhoneBookManager {

	private PhoneInfor[] infors;	//친구정보를 저장하는 배열
	int cnt;	// 배열의 index를 관리해줄 변수 
	
	//생성자(num) =  배열 개수
	public PhoneBookManager(int num) {
		infors = new PhoneInfor[num];
		cnt = 0;
	}
	
	// 배열에 데이터를 저장
	void addPhoneInfor(PhoneInfor i) {
		infors[cnt++] = i;
	}
	
	//스캐너
	Scanner sc = new Scanner(System.in);
	
	// 저장 기능 메소드 (1. 일반 2. 대학 3. 회사 4. 동호회)	
	void addAllInfor(int count) {
		System.out.println("============정보 저장을 실행합니다============");
		System.out.println("이름을 입력하세요.");
		String name = sc.nextLine();
				
		System.out.println("전화번호를 입력하세요.");
		String phoneNumber = sc.nextLine();
				
		System.out.println("주소를 입력하세요.");
		String address = sc.nextLine();
				
		System.out.println("이메일을 입력하세요.");
		String email = sc.nextLine();
		
		switch(count) {
		case 1 :
			System.out.println("일반 정보로 저장을 완료했습니다.");
			//배열에 저장
			addPhoneInfor(new PhoneInfor(name, phoneNumber, address, email));
			break;
			
		case 2 :
			System.out.println("대학 추가정보를 입력합니다.");
			System.out.println("전공을 입력해주세요");
			String major = sc.nextLine();
			System.out.println("학년을 입력해주세요");
			String year = sc.nextLine();
			System.out.println("대학 정보로 저장을 완료했습니다.");
			//배열에 저장
			addPhoneInfor(new PhoneUnivInfor(name, phoneNumber, address, email, major, year));
			break;
			
		case 3 :
			System.out.println("회사 추가정보를 입력합니다.");
			System.out.println("회사 이름을 입력해주세요");
			String company = sc.nextLine();
			System.out.println("회사 정보로 저장을 완료했습니다.");
			//배열에 저장
			addPhoneInfor(new PhoneCompanyInfor(name, phoneNumber, address, email, company));
			break;
			
		case 4 :
			System.out.println("동호회 추가정보를 입력합니다.");
			System.out.println("동호회 이름을 입력해주세요");
			String clubName = sc.nextLine();
			System.out.println("동호회 정보로 저장을 완료했습니다.");
			//배열에 저장
			addPhoneInfor(new PhoneClubInfor(name, phoneNumber, address, email, clubName));
			break;
		}
	}
	// 저장된 정보를 출력하는 메소드
	public void showAllInfor() {
		System.out.println("==========저장된 정보를 출력합니다========");
		for(int i=0; i<cnt; i++) {
			infors[i].showPhoneInfor();
			System.out.println("===================================");
		}
	}
}
	

 
