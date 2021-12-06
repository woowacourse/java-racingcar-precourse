package racingcar;

import static racingcar.util.Constants.*;

import java.util.ArrayList;
import java.util.List;

import racingcar.util.InputManager;

public class RacingPlayer {
	private List<Car> participantCars = new ArrayList<>();
	private int driveCount;
	private RacingReferee referee = new RacingReferee();

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

	public void startRacing() {
		System.out.println(MESSAGE_PRINT_DRIVE_RESULT);
		for (int i = 0; i < driveCount; i++) {
			driveEveryCar();
		}
		finishRacing();
	}

	private void driveEveryCar() {
		participantCars.stream().forEach(car -> car.drive());
		System.out.println();
	}

	private void finishRacing() {
		referee.showWinners(participantCars);
	}
}
