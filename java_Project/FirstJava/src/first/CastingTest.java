package first;

public class CastingTest {

	public static void main(String[] args) {
	
		// 조상클래스 타입의 참조변수
		Car1 car = null;
		FireEngine fe = null;
		
		// 다향성
		car = new FireEngine();
		 fe = new FireEngine();
		 
		//fe = new Car1();  //에러 	//Car1에는 water 기능이 없음.
		 
		FireEngine fe2 = null;
		
		fe.water();
		
		// 형변환 연산 생략 가능
		car = fe; // Car1 = FireEngine //(Car1)안써도 자동 형변환 ok.
		
		// car.water(); 	//타입이 Car1 이기 때문에 water() 사용불가
		
		fe2 = (FireEngine)car; // 조상타입에서 자손타입으로의 형변환은 명시적으로 연산자를 사용해야 한다.
		
		fe2.water();
		
		//car = new Ambulance();
		
		FireEngine f3 = null;
		
		if(car instanceof FireEngine) {  //instanceof 형변환 가능한지 확인 할 수 있음
			f3 = (FireEngine)car;
			f3.water();
		} else {
			System.out.println("불을 끌수 없어ㅓㅓㅓㅓㅓㅓㅓㅓㅓ쉿");
		}
		
		
		
	}
}

class Car1 {
	private String color;
	private int door;
	
	void drive() {
		System.out.println("운전한다 부르우웅우우웅~~");
	}
	
	void stop() {
		System.out.println("멈춘다 끼이이이이익~~~");
	}
	
}

class FireEngine extends Car1 {
	void water() {
		System.out.println("물뿌리기 하이드로펌푸치이이이");
	}
}

class Ambulance extends Car1 {
	
}
