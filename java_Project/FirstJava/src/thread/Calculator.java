package thread;

public class Calculator {
	
	// 동기화 문제를 해결해보자.
	// synchronized (this)키를 사용해서 순서가 정리되어 동기화 이슈가 일어나지 않음.
	
	int opPlusCnt = 0;
	int opMinCnt = 0;
	 public int add(int n1, int n2) {
		// 키를 서로 다른것으르 사용함 this
		 synchronized(this) {
			 opPlusCnt++; 
		 }
		 
		return n1 + n2;
	}

	public synchronized int min(int n1, int n2) {
		// 키를 서로 다른것으르 사용함 obj
		synchronized (obj) {
			opMinCnt++;	
		}
		
		return n1-n2;
	}
	
	// 새로운 동기화 키 -> 인스턴스는 한개의 키값만 가질 수 있음.
	Object obj = new Object();
	
	
	
}
