package thread;

import javax.swing.JOptionPane;

public class ThreadTestMain2 {
	
	// **다른 쓰레드** 에서 참조가 가능한 클래스 변수!
	public static boolean check = false;
	
	public static void main(String[] args) {
	
		
		
		InputAgeThread iat = new InputAgeThread();
		CountDownThread cdt = new CountDownThread();
		
		iat.start();
		cdt.start();
		
//		String age = JOptionPane.showInputDialog("나이를 입력해 주세요.");
//		
//		int ageNumber = Integer.parseInt(age);
//		
//		System.out.println("저의 나이는 "+ age + "살 입니다.");
//		
//		for(int i=10; i>0; i--) {
//			System.out.println(i);
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}			
		}
		

}

class InputAgeThread extends Thread {

	@Override
	public void run() {
		System.out.println("10초안에 입력해라 우하하하하 안그러면 터진다.");
		String age = JOptionPane.showInputDialog("나이를 입력해 주세요.");
		System.out.println("저의 나이는 "+ age + "살 입니다.");
		ThreadTestMain2.check = true;
	}
	
}


class CountDownThread extends Thread {
	
	@Override
	public void run() {
		
		for(int i=10; i>0; i--) {
			
			if(ThreadTestMain2.check) {
				break;
			}
			
			System.out.println(i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		System.exit(0);
	}
}