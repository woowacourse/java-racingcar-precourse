package domain;
/**
 * 자동차의 정보나 기능을 담는 클래스
 * 
 * @author wschoi8640
 * @version 1.1
 */
public class Car {
	private final String name;
	private int position = 0;
	
	public Car(String name) {
		this.name = name;
	}
	
	public int getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}
	/**
	 * 자동차를 전진시키는 메소드
	 */
	public void move() {
		position = position + 1;
	}

}
