package solo;

public class ExtendsSolo {

	public static void main(String[] args) {
	
		Childd c = new Childd() ;
		c.method();

	}

}

class Parent {
	int x = 10;
}

class Childd extends Parent {
	int x = 20;
	
	
	void method() {
		System.out.println("x = " + x);
		System.out.println("this.x = " + this.x);
		System.out.println("super.x = " + super.x);
	}
}

