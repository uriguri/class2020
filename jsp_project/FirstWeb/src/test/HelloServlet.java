package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// ���� : html ���� ��ȯ
		// ���� ���� ��ü : HttpServletResponse response
		
		// ����Ʈ Ÿ�԰� ĳ���ͼ� ����
		resp.setContentType("text/html; charset=UTF-8");
		
		// ����ó���� ����� ��¥�� �ð�������
		Date now = new Date();
		
		// HTML�� ����ó���� ���� ��Ʈ�� ����
		PrintWriter writer = resp.getWriter();
		
		// ���� �����͸� ��� : html ����
		writer.println("<html>");
		writer.println("<head><title>now Date</title></head>");
		writer.println("<body>");
		writer.println("<h1> ����ð� : ");
		writer.println(now); // now.toString()
		writer.println("</h1>");
		writer.println("<h1> �������� ������ �ڵ��Դϴ�");
		writer.println("</h1>");
		writer.println("</body>");
		writer.println("</html>");
		
		writer.close();
	}
	

}
