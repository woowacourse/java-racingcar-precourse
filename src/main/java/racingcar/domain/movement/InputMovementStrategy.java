package racingcar.domain.movement;

public class InputMovementStrategy implements MovementStrategy {

	private int distance;

	public InputMovementStrategy(int distance) {
		this.distance = distance;
	}

	@Override
	public int move() {
		return distance;
	}
}
