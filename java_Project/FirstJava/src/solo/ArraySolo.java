package solo;

public class ArraySolo {

	public static void main(String[] args) {
		
		//일반적인 방식의 변수 선언
		int num1, num2, num3, 
			num4, num5, num6, 
			num7, num8, num9;
		
		num1 = num2 = num3=10;
		num4 = num5 = num6=10;
		num7 = num8 = num9=10;
		
		System.out.println(num1);
//=============================================				
		//배열 기반의 변수 선언
		int[] numArr = new int[9];
	
		for(int i=0; i<9; i++) {
			numArr[i]=10;
		}
		
		System.out.println(numArr[1]);
//=============================================				
		int[] arr = new int[3];
		
		arr[0]=1;
		arr[1]=2;
		arr[2]=3;
		
		int sum = arr[0]+arr[1]+arr[2];
		System.out.println(sum);
//============================================		
		String[] strArr = new String[3];
		strArr[0] = new String ("Java");
		strArr[1] = new String ("Flex");
		strArr[2] = new String ("Ruby");
		
		for(int i=0; i<strArr.length; i++) {
			System.out.println(strArr[i]);
		}
//=============================================	
	 // int[] arr2 = new int[3];
		
		int[] arr2 = {1,2,3};    // 같은 상태
		
		String[] arrStr2 = {"월","화","수","목","금","퇼"};
//=============================================
		
		
		
	}

}
