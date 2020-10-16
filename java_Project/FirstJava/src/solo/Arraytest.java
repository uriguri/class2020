package solo;

import java.util.Scanner;

public class Arraytest {

	
	/*
	문제 1.
	int형 1차원 배열을 매개변수로 전달 받아서 배열에 저장된 최대값,
	그리고 최소값을 구해서 반환하는 메소드를 다음의 형태로 각각 정의.
	public static int miniValue(int[] arr) { . . . . } // 최소값 반환
	public static int maxValue(int[] arr) { . . . . } // 최대값 반환
	위의 두 매소드는 인자로 전달되는 배열의 길이에 상관없이 동작하도록 정의.
	두 매소드 실행을 확인인하기 위한 main 메소드 정의.
	int형 배열에 채워질 정수는 프로그램 사용자로부터 입력 받고, 배열의 길이는 임의로 결정 
	 
	 */
	
	//최소값 구하기
	public static int miniValue(int[] arr) {
		//첫번째 값 (비교용)
		int result = arr[0];
		// 배열의 길이만큼 비교하여 대입 시작이 0이므로 i를 1부터 시작.
		for(int i=1; i<arr.length; i++) {
			
			if(result>arr[i]) {
				result = arr[i];
			} 
		}
		return  result;
	}
	
	
	//최대값 구하기
	public static int maxValue(int[] arr) {
		int result = arr[0];
		for(int i=1; i<arr.length; i++) {
			if(result<arr[i]) {
				result=arr[i];
			}
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	
	int num;
	
	System.out.println("배열의 길이 입력");
	num = sc.nextInt();
	
	int arr[] = new int[num];
	
	Arraytest a1 = new Arraytest();
	
	for(int i=0; i<arr.length; i++) {
		System.out.println("배열에 들어갈 숫자 입력");
		arr[i]=sc.nextInt();
	}
	
	System.out.println("최소값은 = " + a1.miniValue(arr));
	System.out.println("최대값은 = " + a1.maxValue(arr));

	}

}
