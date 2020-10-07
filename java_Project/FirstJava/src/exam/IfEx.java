package exam;

public class IfEx {

	public static void main(String[] args) {
	
/*
		다음과 같이 출력이 이루어지도록 작성해보자.
		num < 0 이라면 “0 미만” 출력
		0 ≤ num <100 이라면 “0이상 100 미만“ 출력
		100 ≤ num < 200 이라면 “100이상 200 미만“ 출력
		200 ≤ num < 300 이라면 “200이상 300 미만“ 출력
		300 ≤ num 이라면 “300이상 “ 출력
*/
		
/*
	int num = 0;
	
	if(num<0) {
		System.out.println("0 미만");
	}
	else if(0 <= num && num<100) {
		System.out.println("0이상 100미만");
	}
	else if(100 <= num && num < 200) {
		System.out.println("100이상 200미만");
	}
	else if(200 <= num && num < 300) {
		System.out.println("200이상 300미만");
	}
	else if (num <= 300) {
		System.out.println("300이상");
	}
*/
//----------------------------------------------------		
/*
  		﻿(3항 연산자)를 사용하지 않고
		﻿if~else를 사용하는 형태로 변경해 보자. ﻿
		int num1=50, num2=100;
		int big, diff;
		big = (num1>num2)? num1:num2;
		System.out.println(big);
		diff = (num1>num2)? num1-num2: num2-num1;
		System.out.println(diff);	
 */
		int num1 = 50;
		int num2 = 100;
		int big = 0, diff = 0;
		
		if(num1>num2) {
			big = num1;
			}
		
		else {
			big = num2;
		}
	System.out.println(big);
		
		if(num1>num2) {
		diff = num1-num2;
		}
		
		else {
		diff = num2-num1;
		}
	System.out.println(diff);
		
		
	
	
	
	
	
	}
}