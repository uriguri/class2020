package thread;

// 쓰레드 클래스 정의는 Thread 클래스를 상속해서 정의한다.
public class ShowThread extends Thread {

	String threadName;
	
	//생성자 호출 및 초기화
	public ShowThread(String name) {
		threadName = name;
	}
	
	@Override //Thread의 run method를 오버라이딩
	public void run() {
		// 새로운 실행 환경에서 처리할 코드를 작성
		
		for(int i=0; i<100; i++) {
			System.out.println("안녕하세요를레이히." + threadName + "입니다.");
			try {
				// Object 클래스의 sleep(m/s)메서드 : 현재 쓰레드를 1/1000 간격으로 멈춤->100/100000->1/10	
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
		System.out.println(threadName + "쓰레드가 종료되었습니다.");
	}
	

	
	
	
	
	
}
