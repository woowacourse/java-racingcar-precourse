package racingcar;

/**
 * <h1>레이싱 게임에서 사용할 자동차에 정보</h1>
 *
 * @author yunki kim
 * @version 1.1
 * @since 2021-12-01(V1.0)
 */

public class Car {

	private static final Integer SHOULD_GO_FORWARD = 3;

	private RandomGenerator randomGenerator;

    private final String name;

    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, RandomGenerator randomGenerator) {
    	this.name = name;
    	this.randomGenerator = randomGenerator;
	}

	public String getName() {
		return this.name;
	}

	public int getPosition() {
		return this.position;
	}

	public void goForward() {
		if (randomGenerator.getRandomNumber() <= SHOULD_GO_FORWARD) {
			return;
		}
		this.position++;
	}
}
