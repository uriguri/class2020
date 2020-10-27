package thread;

// 쓰레드 클래스 정의할 때 상속이 필요한 경우 Runnable 인터페이스를 구현해서 쓰레드를 생성할 수 있다.
public class ShowRunnable implements Runnable{

	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println("안녕하세요를레이히. Runnable 입니다.");
			try {
				// Object 클래스의 sleep(m/s)메서드 : 현재 쓰레드를 1/1000 간격으로 멈춤->100/100000->1/10	
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
		System.out.println("Runnable 쓰레드가 종료되었습니다.");
		
	}

}
