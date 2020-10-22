package basic;

import java.util.Random;

public class RandomNumberGenerator {

	public static void main(String[] args) {
	
		Random r = new Random();
		
		System.out.println(r.nextBoolean());
		System.out.println(r.nextInt());
		System.out.println(r.nextLong());
		System.out.println(r.nextFloat());
		
		System.out.println(r.nextInt(45)+1); //( 0 ~ 44 ) + 1;
		
		System.out.println("이번주 번호 예상");
		for(int i=0; i<6; i++) {
			System.out.print(r.nextInt(45)+1+"\t");
		}
		
		Random r2 = new Random(7); // <- 씨드 가짜난수
		System.out.println("\n이번주 번호 예상");
		for(int i=0; i<6; i++) {
			System.out.print(r2.nextInt(45)+1+"\t");
		}
		
		Random r3 = new Random(System.currentTimeMillis());
		System.out.println("\n이번주 번호 예상");
		for(int i=0; i<6; i++) {
			System.out.print(r3.nextInt(45)+1+"\t");
		}
		
		System.out.println("\n"+System.currentTimeMillis());
		System.out.println(System.nanoTime());
		
	}

}
