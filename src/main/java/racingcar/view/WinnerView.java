package racingcar.view;

import static racingcar.constant.StringConstant.*;

import java.util.stream.Collectors;

import racingcar.car.Car;
import racingcar.winner.WinnerList;

public class WinnerView implements View {
	private final WinnerList winnerList;

	public WinnerView(WinnerList winnerList) {
		this.winnerList = winnerList;
	}

	@Override
	public void printView() {
		String winnerString = getWinnerMessage();
		System.out.print(WINNER_PREFIX_MESSAGE);
		System.out.println(winnerString);
	}

	private String getWinnerMessage() {
		String winnerString =
			winnerList.getWinnerCarList().stream()
				.map(Car::getName)
				.collect(Collectors.joining(WINNER_LIST_DIVIDER));
		return winnerString;
	}
}
