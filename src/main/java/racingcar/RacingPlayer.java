package racingcar;

import static racingcar.util.Constants.*;

import java.util.ArrayList;
import java.util.List;

import racingcar.util.InputManager;

public class RacingPlayer {
	private List<Car> participantCars = new ArrayList<>();
	private int driveCount;

	RacingPlayer() {
		setParticipantCars();
		setDriveCount();
	}

	private void setParticipantCars() {
		String[] carNames = InputManager.readCarName();
		for (String carName : carNames) {
			participantCars.add(new Car(carName));
		}
	}

	private void setDriveCount() {
		int inputDriveCount = InputManager.readDriveCount();
		this.driveCount = inputDriveCount;
	}
}
