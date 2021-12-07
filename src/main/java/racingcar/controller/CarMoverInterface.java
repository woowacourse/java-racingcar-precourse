package racingcar.controller;

import java.util.List;

import racingcar.model.classes.GameData;

public interface CarMoverInterface {
	String getFullTrackRecord(GameData gameData);

	List getWinners(GameData gameData);
}
