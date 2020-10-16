package product;

public class Product { // 눈에 보이지않지만 extends Object가 숨어있음~!

	 int price;
	 int bonusPoint;
	
	// 생성자
	public Product(int price) {
		// super(); // 그래서 super가 등장함 (Object)때문에 생략해도 됨
		
		this.price = price;
		this.bonusPoint = price/10; //or (int)(price*0.1f);
	}

	@Override
	public String toString() {
		return "Product [price=" + price + ", bonusPoint=" + bonusPoint + "]";
	}

	
	
}
