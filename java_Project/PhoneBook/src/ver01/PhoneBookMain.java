package ver01;

public class PhoneBookMain {

	public static void main(String[] args) {
		
		PhoneInfor pi1 = new PhoneInfor("손흥민", "010-000-0000", "1990.12.10");
		pi1.showInfor();  // 참조변수 pi1이 가르키는 PhoneInfor 타입 객체의 메서드
		
		PhoneInfor pi2 = new PhoneInfor("박지성", "010-1111-1111");
		pi2.showInfor();
		
		
		
	}

}
