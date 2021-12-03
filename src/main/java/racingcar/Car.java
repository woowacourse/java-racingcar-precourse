package racingcar;

/**
 * <h1>레이싱 게임에서 사용할 자동차에 정보</h1>
 *
 * @author yunki kim
 * @version 1.0
 * @since 2021-12-01(V1.0)
 */

public class Car {

	/** 자동차 전진 여부를 결정한다. 난수가 이 값보다 크면 전진한다 */
	public static final Integer SHOULD_GO_FORWARD = 3;

	/** 자동차 이름 */
    private final String name;

    /** 자동차의 현재 위치 */
    private int position = 0;

    /**
	 * Car 인스턴스를 생성하는 생성자
	 *
	 * @param name 자동차 이름
	 */
    public Car(String name) {
        this.name = name;
    }

	/**
	 * 자동차 이름을 반환한다
	 *
	 * @return String 자동차 이름
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 자동차의 현재 위치를 반환한다
	 *
	 * @return int 자동차의 현재 위치
	 */
	public int getPosition() {
		return this.position;
	}

	/**
	 * 자동차가 앞으로 전진할지 여부를 판단한다
	 * 전진할 조건이 되면 앞으로 전진한다
	 */
	public void goForward() {
		final RandomNumber randomNumber = new RandomNumber();
		if(randomNumber.getRandomNumber() <= SHOULD_GO_FORWARD) {
			return;
		}
		this.position++;
	}
}
