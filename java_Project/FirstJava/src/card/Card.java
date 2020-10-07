package card;

public class Card {

	String kind; // 카드의 종류
	int number;  // 카드의 숫자
	
	//인스턴스 변수를 사용(구분)하기위해  this 를 붙임
	
	Card(String kind, int number){
		this.kind = kind;
		this.number = number;
	}
	Card(){
		// 다른 생성자를 호출
		this("spade", 1);
	}
	
	// 클래스 변수 선언
	static int width = 100;  // 카드의 폭
	static int height = 250; // 카드의 높이
	
	/*
	void play() {
		System.out.println("카드놀이를 합니다.");
	}
	*/
	static void play() {
		System.out.println("카드놀이를 합니다.");
	}
}
