package exam;

public class GlassBall {
	
 // 변수 : 어린이1구슬, 어린이2구슬
	
	int glassBall1;
	int glassBall2;
	
 // 구슬 갯수를 변경하는 메소드
	
	void changeData (int g1, int g2) {
		glassBall1 = g1;
		glassBall2 = g2;
	}
	
 // 이기면 얻는 구슬
	int winGB(int getGB) {
		
		int num = 0; //얻은 구슬의 갯수 초기화
		
		num = getGB;	// 얻은 구슬의 갯수를 구한다.
		
		glassBall1 += num; //구슬의 갯수 증가
		
		return num;
		
	}
// 지면 잃는 구슬
	int loseGB(int lostGB) {
		int num = 0; // 잃은 구슬의 갯수 초기화
		
		num = lostGB; // 잃은 구슬의 갯수를 구한다.
		
		glassBall1 -= num; // 구슬의 갯소 감소
		
		return num;
	}
	
// 보유한 구슬 갯수 출력
	void showChild1() {
		System.out.println("현재 보유한 구슬 갯수 = " + glassBall1);
	}
}
