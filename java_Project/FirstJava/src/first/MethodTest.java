package first;

public class MethodTest {

	public static void main(String[] args) {
		 
		MyMath my = new MyMath();
		
		System.out.println( my.add(1, 5));
		
		my.sayHello();
		
		my.plus(10,20);
		
		System.out.println(my.check());
		
		hiEveryone();
		
		my.div(99, 0);
		my.div(99, 5);
		
	
	}
	
		static void hiEveryone() {
			System.out.println("안녕하세요");
		}
		
		

		
}