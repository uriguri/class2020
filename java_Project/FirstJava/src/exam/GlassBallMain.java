package exam;

public class GlassBallMain {

	public static void main(String[] args) {
		//구슬 호출
		GlassBall GB = new GlassBall();
		
		// 구슬 값 입력 아이1 아이2
		GB.changeData(15, 9);
		
		// 얻은구슬
		int result = GB.winGB(2);
		System.out.println(" 어린이 1의 구슬 현황");
		GB.showChild1();

	}

}
