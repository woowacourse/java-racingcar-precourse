package racingcar.controller.classes;

import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.HashMap;
import java.util.List;

import racingcar.controller.CarMoverInterface;
import racingcar.model.classes.Car;
import racingcar.model.classes.GameData;

public class CarMover implements CarMoverInterface {

	private boolean goByRandom() {
		int decider = pickNumberInRange(0,9);
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
			List<Car> tmpCars = gameData.getCars();
			for (Car car : tmpCars) {
				if(goByRandom()) {
					car.go();
				}
			}
			gameData.setCars(tmpCars);
			fullTrackRecord += gameData.getTrackStatus();
			fullTrackRecord += "\n";
		}
		return fullTrackRecord;
	}

	@Override
	public String[] getWinners(GameData gameData) {
		HashMap<Integer, List<String>> findMaxMap;
		for (Car car : gameData.getCars()) {
		}
		return new String[0];
	}
}
