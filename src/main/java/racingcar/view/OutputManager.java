package racingcar.view;

import java.util.List;

import racingcar.constants.RaceConstants;
import racingcar.constants.ViewConstants;
import racingcar.domain.Car;

public class OutputManager {

	public void notifyRaceResult() {
		System.out.println(ViewConstants.NOTIFY_RESULT);
	}

	public void notifyCarsStatement(List<Car> cars) {
		for(Car car : cars) {
			car.notifyStatement();
		}
		System.out.println();
	}

	public void notifyWinners(List<String> winners) {
		printWinnerStart();
		for(int i = 0; i < winners.size(); i++) {
			System.out.print(winners.get(i));
			printCommaAndBlank(i, winners.size());
		}
	}

	private void printWinnerStart() {
		System.out.print(ViewConstants.NOTIFY_RACE_WINNERS);
	}

	private void printCommaAndBlank(int nowIndex, int size) {
		if(nowIndex != size - 1) {
			System.out.print(RaceConstants.CUT_OFF_POINT + RaceConstants.BLANK);
		}
	}
}
