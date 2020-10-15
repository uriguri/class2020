package test;

public class AAA {

	//public AAA(){} 디폴트 생성자가 자동으로 들어감.
	
	int num;
	
	public static int n = 100;
	
	//static AAA a = new AAA();
	
	AAA(){
		
	}
	
	
	// setter (설정 할 수 있는 메서드)
	public void setNum(int num) {
		this.num = num;
	}
	
	// getter (값을 얻을 수 있는 메서드)
	public int getNum() {
		return num;
	}
}
