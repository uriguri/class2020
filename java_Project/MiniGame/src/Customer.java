import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Customer {

	
	// 손님이 menu 를 주문한다.
	
	void order(String menu) {
		System.out.println("손님 : " + menu + "주세요.");
	}
	
	void choiceMenu(){
	final String[] menu = new String[] {"아메리카노", "카페 라떼", "카페 모카", "바닐라 라떼"};
	// 섞기
	final List<String> menuList = Arrays.asList(menu);
	Collections.shuffle(menuList);
	// 테스트
	menuList.stream().limit(1).forEach(System.out::println);
	}
	
	}


	