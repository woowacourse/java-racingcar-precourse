package racingcar.controller;

import racingcar.model.classes.GameData;

public interface CarMoverInterface {
	String getFullTrackRecord(GameData gameData);

	String[] getWinners(GameData gameData);
}
