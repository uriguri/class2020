package ver04;

public class PhoneClubInfor extends PhoneInfor{

	//Club Infor에는 Club 이름을 입력가능하게 추가하였음.
	private String clubName;
	
	
	PhoneClubInfor(String name, String phoneNumber, String address, 
				   String email, String clubName) {
		super(name, phoneNumber, address, email);
		this.clubName = clubName;
	}


	@Override
	public void showData() {
		super.showData();
		System.out.println("동호회명 : " + clubName);
	}
	
}