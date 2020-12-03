package racingcar;

/**
 * 자동차 객체를 정의하는 클래스
 * 기능 1. Car 객체의 멤버 position을 1만큼 증가시키는 기능
 * 기능 2. 출력 요구사항에 맞춰 Car 객체의 정보를 문자열로 리턴하는 기능
 */
public class Car {
	private static final String SEPERATOR_COLON = " : ";
	private static final String MOVING_HYPHEN = "-";
	private static final Integer ZERO = 0;

	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public void moveForwardByOne() {
		position++;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(name).append(SEPERATOR_COLON);

		for (int idx = ZERO; idx < position; idx++) {
			sb.append(MOVING_HYPHEN);
		}

		return sb.toString();
	}
}
