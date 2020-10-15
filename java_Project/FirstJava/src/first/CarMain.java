package first;

public class CarMain {
	
public static void main(String[] args) {
		
		Car car1 = new Car(100);
		HybridCar car2 = new HybridCar(100, 50);
		HybridWaterCar car3 = new HybridWaterCar(100, 50, 40);
		
		car3.showCurrentGauge();
	}

}	

	class Car {
		
		int gasolinegauge;
		
		//Car(){};
		
		Car(int gasolinegauge) {
			this.gasolinegauge = gasolinegauge;
		}
	}

	class HybridCar extends Car {
		
		int electronicGauge;
		
		// HybridCar(){
		// super();
		// }
		
		HybridCar(int gasolinegauge, int electronicGauge){
			// 조상 클래스의 멤버를 초기화 하는 생성자 호출
			super(gasolinegauge);
			// 새롭게 정의한 클래스의 멤버를 초기화
			this.electronicGauge = electronicGauge;
		}
	}

	class HybridWaterCar extends HybridCar {
		
		int waterGauge;
		
		// HybridWaterCar(){
		// super();
		// }
		
		HybridWaterCar(int gasolinegauge, int electronicGauge, int waterGauge){
			super(gasolinegauge, electronicGauge);
			this.waterGauge = waterGauge;
		}

		public void showCurrentGauge() {
			System.out.println("잔여 가솔린 : " + gasolinegauge);
			System.out.println("잔여 전기 : " + electronicGauge);
			System.out.println("잔여 water : " + waterGauge);
		}
}

	
