package domain;

/**
 * 자동차 경주 게임에 사용되는 자동차 객체
 * @version 1.00 19.03.31
 * @author ep1stas1s
 */
public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	/**
	 * random 값이 4 이상일 경우 position이 1증가
	 */
	public void move() {
		int random = make0to9RandomValue();
		if (random < 4) {
			return;
		}
		position++;
	}

	public int make0to9RandomValue() {
		return (int)(Math.random() * 9);
	}

	/**
	 * 현재 Car의 position을 막대바('-')로 출력
	 */
	public void printPosition() {
		System.out.print(name + " : ");
		for (int i = 0; i < position; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
