package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
		System.out.println("실행 결과");
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
