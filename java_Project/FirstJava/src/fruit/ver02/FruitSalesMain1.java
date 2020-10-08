package fruit.ver02;

public class FruitSalesMain1 {

	public static void main(String[] args) {
		
		// FruitSeller 타입의 참조변수 선언
		FruitSeller seller = null;
		
		// FruitSeller의 객체 생성
		// 객체의 생성은 클래스에 정의된 멤버(변수, 메서드)들을 메모리에 등록하는 것
		seller = new FruitSeller(); // 객체의 주소값을 반환
	
		// 셀러 3
		FruitSeller seller3 = new FruitSeller(seller);
		
		// FruitBuyer 타입의 참조변수 선언과 초기화 (한번에 처리)
		FruitBuyer buyer = new FruitBuyer();
		
		
		
		// 사과를 구매 : 2000 지불
		buyer.buyApple(seller, 2000);
		
		buyer.buyApple(seller3, 1500);
		
		System.out.println("판매자의 현재 지표");
		seller.showSaleResult();
		
		System.out.println("판매자3의 현재 지표");
		seller3.showSaleResult();
		
	System.out.println("====================================");
	
		System.out.println("구매자의 현재 지표");
		buyer.showBuyResult();
		
		// 자주 겪는 에러 미스매치타입.
		//String s = "FruitSeller";
		//seller = s;
		
	}

}
