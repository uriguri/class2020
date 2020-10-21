package first;

public class ExceptionCase2 {

	public static void main(String[] args) {
		
		try {
		int[] arr = new int[3]; // index -> 0~2
		// arr[10] = 20;
		
		// arr = new int[-10];
		
		 Object obj = new int[10];
		//String str = (String)obj;
		
		String str = null;
		int len = str.length();
		
		
		
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
			
		} catch(NegativeArraySizeException e) {
			System.out.println(e.getMessage());
			
		} catch (ClassCastException e) {
			System.out.println(e.getMessage());
			
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
			
		} catch (Exception e) { //상위 Exception으로 모든예외걸러냄 세세하게 구분 불가
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("메서드가 종료됩니다.");
		
		
		
		
		
		
		
		
		
		
		
		

	}

}