package racingcar.controller.classes;

import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.ArrayList;
import java.util.List;

import racingcar.controller.CarMoverInterface;
import racingcar.model.classes.Car;
import racingcar.model.classes.GameData;

public class CarMover implements CarMoverInterface {

	private boolean goByRandom() {
		int decider = pickNumberInRange(0, 9);
		if (decider >= 4) {
			return true;
		}
		return false;
	}

	@Override
	public String getFullTrackRecord(GameData gameData) {
		int count = gameData.getCounts();
		String fullTrackRecord = "";
		for (int i = 0; i < count; i++) {
			List<Car> tmpCars = getOneLineRecord(gameData);
			gameData.setCars(tmpCars);
			fullTrackRecord += gameData.getTrackStatus();
			fullTrackRecord += "\n";
		}
		return fullTrackRecord;
	}

	private List<Car> getOneLineRecord(GameData gameData) {
		List<Car> tmpCars = gameData.getCars();
		for (Car car : tmpCars) {
			if (goByRandom()) {
				car.go();
			}
		}
		return tmpCars;
	}

	@Override
	public List getWinners(GameData gameData) {
		List<String> winners = new ArrayList<>();
		int maxPosition = figureOutMaxPosition(gameData);
		return getWinnersList(gameData, winners, maxPosition);
	}

	private List<String> getWinnersList(GameData gameData, List<String> winners, int maxPosition) {
		for (Car car : gameData.getCars()) {
			if (car.getPosition() == maxPosition) {
				winners.add(car.getName());
			}
		}
		return winners;
	}

	private int figureOutMaxPosition(GameData gameData) {
		int maxPosition = -1;
		for (Car car : gameData.getCars()) {
			if (maxPosition < car.getPosition()) {
				maxPosition = car.getPosition();
			}
		}
		return maxPosition;
	}
}
