package first;

public class ExamOper1 {

	public static void main(String[] args) {
		
		/*﻿
		아래의 코드는 사과를 담는데 필요한 바구니(버켓)의 수를 구하는 코드이다.
		만일 사과의수가 123개이고 하나의 바구니에는10개의 사과를 담을 수 있다면,
		13개의 바구니가 필요할 것이다.
	       알맞은 코드를 넣으시오.
		 */
		
		int numOfApples =123; // 사과의 개수
		int sizeOfBucket =10; // 바구니의 크기(바구니에 담을 수 있는 사과의 개수)
		
		// 전체 사과를 10으로 나눈 나머지를 구하고,
		// 나머지가 10보다 크면 바구니 개수를 1 증가
		
	//	(조건문)
	//	if(numOfApples%10>0){
	//		numOfBucket++;
	//	}
		
		//바구니의 개수 numOfBucket (삼항 연산자)
		//여기서 10 = sizeOfBucket
		int numOfBucket = numOfApples/10 + (numOfApples%10 > 0 ? 1 : 0);
		
		//모든 사과를 담는데 필요한 바구니의 수
		System.out.println("필요한 바구니의 수 : " + numOfBucket);
		
		/*﻿
		아래는 화씨(Fahrenheit)를 섭씨(Celcius)로 변환하는 코드이다.
		변환공식이 'C =5/9 ×(F - 32)'라고 할 때,
		(1)에 알맞은 코드를 넣으시오.단, 
		변환 결과값은 소수점셋째 자리에서 반올림해야 한다.
		(Math.round()를 사용하지 않고 처리할 것)
		*/ 
		
		int fahrenheit =100;
		
		// 0.5를 더해줌으로써 반올림 기능 
		// (int)를 붙여도 float가 나오는 이유 -> 내가 헷갈림
		// int로바뀐 결과를 /100f 해서 결국 나오는 값은 -> float임.
		// float 결과물을 celcius 에 담아서 float 값이 나오는 것.
		
		float celcius = (int) ( ( 5/9f * (fahrenheit - 32) ) * 100 + 0.5) / 100f;

		System.out.println("Fahrenheit:"+fahrenheit);

		System.out.println("Celcius:"+celcius);
		
		//형변환﻿
		byte a = 10;

		byte b = 20;

		//byte c = a + b; 
		byte c = (byte)(a + b);

		char ch = 'A';

		//ch = ch + 2;
		ch = (char) (ch + 2);

		//float f = 3 / 2;
		float f = 3 / 2f;

		//long l = 3000 * 3000 * 3000;
		long l = 3000 * 3000 * 3000L;

		float f2 = 0.1f;

		double d = 0.1;

		//boolean result = d==f2; //true가 나와야함
		boolean result = (float)d == f2;

		System.out.println("c="+c);
		System.out.println("ch="+ch);
		System.out.println("f="+f);
		System.out.println("l="+l);
		System.out.println("result="+result);
		
		/*
		ch2가 영문자(대문자 또는 소문자)이거나 
		숫자일 때만 변수b2의 값이true가 되도록 하는 코드이다.
		(1)에 알맞은 코드를 넣으시오.﻿ 
		*/
		char ch2 = 'a';

		boolean b2 =
				(ch2 >= 'a' && ch2 <= 'z')||
		        (ch2 >= 'A' && ch2 <= 'Z')||
		        (ch2 >= '0' && ch2 <= '9');
		
		System.out.println(b2);
		
		/*
		 문자 ch에 저장된 문자가 대문자인 경우에만 소문자로 변경한다.
		 문자코드는 소문자가 대문자보다32만큼 더 크다.
		 예를들어 'A‘의 코드는65이고 ’a'의 코드는97이다. 
		 (1)~(2)에 알맞은 코드를 넣으시오.
		 */
		ch = 'A';
		char lowerCase = (ch>='A' && ch<='Z') ? (char)(ch+32):(ch);
		System.out.println("ch : "  + ch);
		System.out.println("lowerCase : " + lowerCase);
		
		}
}
