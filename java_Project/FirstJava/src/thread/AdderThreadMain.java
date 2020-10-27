package thread;

public class AdderThreadMain {

	public static void main(String[] args) {
		
		AdderThread at1 = new AdderThread(1, 5000);
		AdderThread at2 = new AdderThread(5000, 10000);
		
		// 쓰레드 생성
		Thread t1 = new Thread(at1);
		Thread t2 = new Thread(at2);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();	// t1 쓰레드가 종료될 때 까지 다른 쓰레드는 멈춤상태
			t2.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("1~100 합은 : " + (at1.getNum()+at2.getNum()) );
	}

}
