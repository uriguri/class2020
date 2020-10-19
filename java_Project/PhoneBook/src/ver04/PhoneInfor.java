package ver04;
/*
Project : ver 0.40 
	다음 두 클래스를 추가로 삽입. 상속 구조가 가능하다면 상속 구조로 구성 해보세요. 
	PhoneUnivInfor, PhoneCompaanyInfor, 개인적인 클래스 추가 
	각 클래스에 정의되어야 하는 인스턴스 변수. 
				
	PhoneUnivInfor 					PhoneCompaanyInfor 
	
	이름        name        String 		이름        name         String 
	전화번호   phoneNumber String  		전화번호   phoneNumber  String
	주소        address     String  		주소         address     String
	이메일     email       String  		이메일      email        String  
	----------------------------------------------------------
 	전공       major       String		회사        company      String  
 	학년       year        String 
 
	Ex) PhoneCafeInfor 또는 PhoneFamilyInfor 등을 추가해 보자 
	
	[추가 사항]
	1. 입력    --> 1. 일반  2. 대학  3. 회사  4. 동호회 --> 입력 형태로 구성
*/
public class PhoneInfor {

	// 변수 설정 + 캡슐화
	private String name;		// 친구의이름
	private String phoneNumber; // 전화번호
	private String address;		// 주소
	private String email;		// 이메일
	
	// getter (캡슐화를 했기때문에 Getter를 생성)
	public String getName() {
		return name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public String getEmail() {
		return email;
	}
	
	// 생성자
	PhoneInfor(String name, String phoneNumber, String address, String email) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
	}

	// 출력메소드
	public void showData() {
		System.out.println("이름 : " + getName());
		System.out.println("전화번호 : " + getPhoneNumber());
		System.out.println("주소 : " + getAddress());
		System.out.println("이메일 : " + getEmail());
	}
	
}	