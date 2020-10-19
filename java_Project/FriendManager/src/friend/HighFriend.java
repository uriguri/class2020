package friend;

public class HighFriend extends Friend {

	private String work; // 직업
	
	// 생성자를 통해 인스턴스 변수 초기화 
	HighFriend(String name, String pNum, String addr, String work) {
		super(name, pNum, addr);
		this.work = work;
	}

	@Override
	public void showData() {	// Friend f = new HighFriend() -> f.showData()
		super.showData();
		System.out.println("직업 : " + work);
	}

	@Override
	public void showBasicInfo() {  // Friend에서 캡슐화된 변수를 사용하기위해 Getter를 불러옴.
		System.out.println("이름 : " + getName());
		System.out.println("전화 : " + getPhoneNumber());
	}
	
	

	
}
