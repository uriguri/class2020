package star;

public class Fighter extends Unit implements Fightable {
	
	// 추상메서드 오버라이딩
	
	@Override
	public void move() {
		System.out.println("이동합니다.");
		x += NUM;
		y += NUM;
	}
	
	@Override
	public void attack() {
		System.out.println("공격합니다.");
		hp -= NUM;
	}
}
