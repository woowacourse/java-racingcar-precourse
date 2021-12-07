package racingcar.controller.classes;

import racingcar.controller.CarMoverInterface;
import racingcar.controller.GameDataHandlerInterface;
import racingcar.model.classes.GameData;

public class GameDataHandler implements GameDataHandlerInterface {
	private GameData gameData = new GameData();
	private String fullTrackRecord = "";
	private String[] winners;
	private CarMoverInterface carMoverInterface;
	@Override
	public void makeGameData(String[] names, int counts) {
		gameData.makeData(names, counts);
	}
	@Override
	public String getFullTrackRecord() {
		carMoverInterface = new CarMover();
		fullTrackRecord = carMoverInterface.getFullTrackRecord(gameData);
		winners = carMoverInterface.getWinners(gameData);
		return fullTrackRecord;
	}

	public String[] getWinners() {
		return winners;
	}
}
