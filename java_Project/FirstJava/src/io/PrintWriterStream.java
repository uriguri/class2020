package io;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterStream {

	public static void main(String[] args) throws IOException {
		
		PrintWriter out = new PrintWriter(new FileWriter("print.txt"));
		
		out.printf("안녕하세요. 저는 %d살 %s입니다.", 12, "우리");
		out.println();
		out.print("저는 자바를 좋아합니다.");
		out.print("IO 아주 재미가이쓰요.");
		out.close();
		
		System.out.println("작성완료");
	}

}

