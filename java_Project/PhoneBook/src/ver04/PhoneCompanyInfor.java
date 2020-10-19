package ver04;

public class PhoneCompanyInfor extends PhoneInfor {

	//Company Infor 에는 회사의 입력이 가능해야함.
	private String company;
	
	PhoneCompanyInfor(String name, String phoneNumber, String address,
					   String email, String company) {
		super(name, phoneNumber, address, email);
		this.company = company;
	}

	@Override
	public void showData() {
		super.showData();
		System.out.println("회사 : " + company);
	}

}