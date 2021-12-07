package racingcar.controller;

import java.util.List;

public interface GameDataHandlerInterface {
	void makeGameData(String[] names, int counts);

	String getFullTrackRecord();

	List getWinners();
}
