package first;

public class StringTest {

	public static void main(String[] args) {
		String str1 = "My string";
		String str2 = "My string";
		String str3 = "Your string";
		String str4 = new String("My string");
		
		// 참조변수 값의 비교 
		if(str1==str2) {
			System.out.println("같은 인스턴스 참조");
		}else {
			System.out.println("다른 인스턴스 참조");
		}
		
		if(str1==str3) {
			System.out.println("같은 인스턴스 참조");
		}else {
			System.out.println("다른 인스턴스 참조");
		}
		
		if(str1==str4) {
			System.out.println("같은 인스턴스 참조");
		}else {
			System.out.println("다른 인스턴스 참조");
		}
		
		// 문자열의 내용 비교.
		System.out.println(str1.equals("str"));

		
		
		
	}
}