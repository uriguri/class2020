package ver04;

public class PhoneUnivInfor extends PhoneInfor {

	//Univ Infor 에는 전공과 학년의 입력이 가능해야함.
	private String major; // 전공
	private String year;  // 학년
	
	PhoneUnivInfor(String name, String phoneNumber, String address, 
				   String email,String major, String year) {
		super(name, phoneNumber, address, email);
		this.major = major;
		this.year = year;
	}

	@Override
	public void showData() {
		super.showData();
		System.out.println("전공 : " + major);
		System.out.println("학년 : " + year);
	}
}