package ver04solo;

public class PhoneCompanyInfor extends PhoneInfor {

	private String company;
	
	PhoneCompanyInfor(String name, String phoneNumber, String address, String email, String company) {
		super(name, phoneNumber, address, email);
		this.company = company;
	}

	@Override
	public void showPhoneInfor() {
		super.showPhoneInfor();
		System.out.println("• 회     사 : " + company);
	}

}