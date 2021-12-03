package racingcar.domain;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	// 추가 기능 구현

	// 기본 생성자 추가 금지
	// 접근제어자 수정 금지
	// setPosition(int position) 가능하면 사용 금지

	@Override
	public String toString() {
		return name;
	}
}
