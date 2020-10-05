package first;

public class OperatorEx {

	public static void main(String[] args) {
		
/*
	//1. int 형 변수 num1, num2, num3가 각각 10,20,30 으로 초기화 되어 있다.
		//다음문장을 실행하면 각각 변수에는 어떠한 값이 저장되겠는가?
		//num1=num2=num3 ;
		
		
		int num1 = 10;
		int num2 = 20;
		int num3 = 30;
		
		num1=num2=num3;
		System.out.println("num1 = "+num1+"num2 = "+num2+"num3 = "+num3); // 대입은 오른쪽에서 왼쪽으로 진행
		//num1 = 30 num2 = 30 num3 = 30

	//2. 수학식 {{(25x5)+(36-4)}-72}/5 의 계산결과를 출력하는 프로그램 작성
		
		System.out.println((((25*5)+(36-4))-72)/5); // 산술연산자가 우선순위가 높기때문에 괄호로 묶어서 먼저 계산 할 범위를 지정함.
		//17

	//3. 3+6, 3+6+9, 3+6+9+12 의 연산을 하는 프로그램 작성. 
		//단. 덧셈 연산의 횟수 최소화
		
		int result;
		
		result = 3+6;  // result = 3+6
		System.out.println(result); // 9
		result += 9;   // result = 3+6+9
		System.out.println(result); // 18
		result += 12;  // result = 3+6+9+12
		System.out.println(result); // 30
		
	//4. a={{(25+5)+(36/4)}-72}*5, b= {{(25x5)+(36-4)}-71}/4, c=(128/4)*2 일 때
		//a>b>c 가 참이면 true 아니면 false를 출력하는 프로그램 작성
		
		int a = (((25+5)+(36/4))-72)*5;
		int b = (((25*5)+(36-4))-71)/4;
		int c = (128/4)*2;
		
		System.out.println("a = " + a + "b = " + b + "c = "+ c );
		//a = -165 b = 21 c = 64
		
		boolean result2 = (a>b) && (b>c); // a는 b보다 크다 &&(그리고) b는 c보다 크다
		System.out.println(result2); // false
*/		

		// 연산자 연습
		
/*		
		int i = 5;
		int j = 0;
		j = i++;
		System.out.println("j = i++; 실행 후, i = "+ i +" j = "+j);
		// 1.j에 i가 먼저 대입됨 2.i값에 +1 3.i=6,j=5
		
		i = 5;
		j = ++i;
		System.out.println("j = i++; 실행 후, i = "+ i +" j = "+j);
		// 1. i값에+1 2.증가한 i값이 j에 대입 3. i=6,j=6
		 
*/		
		int i = -10;
		i = +i; 
		System.out.println(i);
		//부호연산자 + 는 1을 곱함.
		// -10 * 1 = -10
		
		i = -10; 
		i = -i;
		System.out.println(i);
		//부호연산자 - 는 -1을 곱함.
		// -10 * -1 = 10
		
		byte b = 10; 
		System.out.println("b = " + b);
		System.out.println("~b = " + ~b);
		//~는 부정 연산자이며 연산을 할때 피연산자를 
		//int형으로 변화시키고 0은 1로 1은 0으로 바꾸는 역할
		

		
		
		
		}
		
	}


