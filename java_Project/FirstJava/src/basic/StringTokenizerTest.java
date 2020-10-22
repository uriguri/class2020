package basic;

import java.util.StringTokenizer;

public class StringTokenizerTest {

	public static void main(String[] args) {
		
		// 구분자 (,)
		String strData = "11,22,33,44,55";
		StringTokenizer st = new StringTokenizer(strData, ",", true);
		
		// 토큰 확인하고 토큰별로 출력..
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		System.out.println("================================");
		String pNum = "Tel 82-010-9999-7777 son";
		StringTokenizer st1 = new StringTokenizer(pNum); // " " 가 구분자로 사용됨
		
		while(st1.hasMoreTokens()) {
			System.out.println(st1.nextToken());
		}
		
		System.out.println("==================================");
		StringTokenizer st2 = new StringTokenizer(pNum, " -"); // 구분자 '-' , ' ' 로 사용됨
		
		while(st2.hasMoreTokens()) {
			System.out.println(st2.nextToken());
		}
		
		System.out.println("==================================");
		
		StringTokenizer st3 = new StringTokenizer(pNum, "- ", true);
		
		while(st3.hasMoreTokens()) {
			System.out.println(st3.nextToken());
		}
		

	}

}
