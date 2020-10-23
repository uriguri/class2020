package collection;

import java.util.ArrayList;

public class LinkedListTest {

	public static void main(String[] args) {

		// List<E> :  저장 순서 유지 (반복문 이용 용이), 중복 저장 허용 (
		// [인스턴스 저장]을 목적으로 하는 클래스
		// List 인스턴스 생성
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		// 데이터 저장 : 참조 값을 저장
		// add(<T>)
		list.add(new Integer(11));
		list.add(new Integer(22));
		list.add(new Integer(33));
		list.add(55);	// Auto Boxing
		list.add(44);
		
		// List 요소 참조
		// <T> get()
		System.out.println("List의 첫 번째 요소의 값 : " + list.get(0));
		
		// List 요소의 개수
		// size()
		System.out.println("List 요소의 개수 : " + list.size());
		
		// 반복문을 이용한 모든 요소 참조
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("-------------------");
		for(Integer i : list) {
			System.out.println(i);
		}
		
		System.out.println("-------------------");
		// List 요소의 삭제
		// rmove(index값)
		// 첫 번째 요소를 삭제
		list.remove(2);
		
		// int i = AutoBoxing, = Integer(11)
		for(int i : list) {
			System.out.println(i);
		}
		
	}

}
