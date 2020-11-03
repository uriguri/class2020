package ver04solo;

public class PhoneClubInfor extends PhoneInfor{

	private String clubName;
	
	
	PhoneClubInfor(String name, String phoneNumber, String address, String email, String clubName) {
		super(name, phoneNumber, address, email);
		this.clubName = clubName;
	}

	@Override
	public void showPhoneInfor() {
		super.showPhoneInfor();
		System.out.println("• 동호회명 : " + clubName);
	}
	
}