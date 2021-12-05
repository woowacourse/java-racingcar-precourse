package racingcar.view;

import java.util.stream.Collectors;

import racingcar.car.Car;
import racingcar.winner.WinnerList;

public class WinnerView implements View {
	private final String PREFIX_MESSAGE = "최종 우승자 : ";
	private final WinnerList winnerList;

	public WinnerView(WinnerList winnerList) {
		this.winnerList = winnerList;
	}

	@Override
	public void printView() {
		String winnerString = getWinnerMessage();
		System.out.print(PREFIX_MESSAGE);
		System.out.println(winnerString);
	}

	private String getWinnerMessage() {
		String winnerString =
			winnerList.getWinnerCarList().stream()
				.map(Car::getName)
				.collect(Collectors.joining(", "));
		return winnerString;
	}
}
