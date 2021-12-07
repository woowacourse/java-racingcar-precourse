package racingcar.controller.classes;

import java.util.List;

import racingcar.controller.CarMoverInterface;
import racingcar.controller.GameDataHandlerInterface;
import racingcar.model.classes.GameData;

public class GameDataHandler implements GameDataHandlerInterface {
	private GameData gameData = new GameData();
	private String fullTrackRecord = "";
	private List winners;
	private CarMoverInterface carMoverInterface;

	@Override
	public void makeGameData(String[] names, int counts) {
		gameData.makeData(names, counts);
	}

	@Override
	public String getFullTrackRecord() {
		carMoverInterface = new CarMover();
		setRecordsByData();
		return fullTrackRecord;
	}

	private void setRecordsByData() {
		setTrackRecordByData();
		setWinnerRecordByData();
	}

	private void setWinnerRecordByData() {
		winners = carMoverInterface.getWinners(gameData);
	}

	private void setTrackRecordByData() {
		fullTrackRecord = carMoverInterface.getFullTrackRecord(gameData);
	}

	@Override
	public List getWinners() {
		return winners;
	}
}
