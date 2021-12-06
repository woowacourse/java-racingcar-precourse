package racingcar;

public class GameHandler {
	public static void startRace() {
		String[] carNames = Input.carName();
		int tryNumber = Input.tryNumber();

		CarList cars = new CarList(carNames);

		for (int i = 0; i < tryNumber; i++) {
			cars.moveAll();
			Output.movementState(cars);
		}
		Output.winners(cars);
	}
}
