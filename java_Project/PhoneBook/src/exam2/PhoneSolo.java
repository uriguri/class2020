package exam2;

public class PhoneSolo {

	//사용 변수
	String name;
	String phoneNumber;
	String birthday;
	
	//생성자 생성
	PhoneSolo(String name, String phoneNumber, String birthday){
	this.name = name;
	this.phoneNumber = phoneNumber;
	this.birthday = birthday;
	}
	
	//오버로드
	PhoneSolo(String name, String phoneNumber){
	this(name, phoneNumber, "생일정보 없음");	
	}
	
    //출력 메소드
	void showSolo() {
		System.out.println("=====================");
		System.out.println("• 이름   : " + name);
		System.out.println("• 번호   : " + phoneNumber);
		System.out.println("• 생일   : " + birthday);
		System.out.println("=====================");
	}	
}