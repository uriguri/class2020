package ver04solo;

public class PhoneUnivInfor extends PhoneInfor{

	private String major;
	private String year;
	
	PhoneUnivInfor(String name, String phoneNumber, String address, String email, String major, String year) {
		super(name, phoneNumber, address, email);
		this.major = major;
		this.year = year;
	}

	@Override
	void showPhoneInfor() {
		super.showPhoneInfor();
		System.out.println("• 전     공  : " + major);
		System.out.println("• 학     년  : " + year);
	}
	
}
