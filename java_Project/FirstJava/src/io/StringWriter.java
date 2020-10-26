package io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class StringWriter {

	public static void main(String[] args) throws IOException {
		
		// 기본 문자 스트림
		Writer writer = new FileWriter("String.txt");
		
		// 필터 스트림 : BufferedWriter 기본스트림 Writer 가 필요함
		BufferedWriter out1 = new BufferedWriter(writer);
		
		out1.write("한우리 - 파일과 I/O스트림을 듣고있습니다.");
		out1.newLine(); // 개행 : 새로운 행에서 문자열을 쓰겠다.
		out1.write("월요일은 너무 졸린 날이다.");
		out1.newLine();
		out1.newLine();
		out1.write("기사입력 완료");
		
		// 스트림 닫기
		out1.close();
		
		System.out.println("기사작성 완료.");
		

	}

}
