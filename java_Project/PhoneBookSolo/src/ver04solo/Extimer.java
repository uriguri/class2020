package ver04solo;

import java.util.Timer;
import java.util.TimerTask;

public class Extimer {

	public static void main(String[] args) {
		
		Timer time = new Timer();
		TimerTask task = new TimerTask() {
			
			int cnt = 0;
			int i = 15;
			
			@Override
			public void run() {
				if(cnt <= 15) {
				
				System.out.println(i+"초");
				
				} else {
					System.out.println("게임 종료 ㅋㅋㅋㅋ");
				time.cancel();
				}
				
			--i;		
			cnt++;
			}
		};
		time.schedule(task, 1000, 1000);
	}
		

	}

