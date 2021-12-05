package racingcar.view;

import java.util.List;

import racingcar.domain.Cars;

public class OutputView {
	public static void printWinners(Cars carList) {
		List<String> winnerList = carList.getWinner();
		String winnerMessage = "최종 우승자 : ";

		for (String winner : winnerList) {
			winnerMessage = winnerMessage.concat(winner);
			winnerMessage = winnerMessage.concat(",");
		}
		System.out.print(winnerMessage.substring(0, winnerMessage.length() - 1));
	}

	public static void printResultMessage() {
		System.out.println("\n실행 결과");
	}
}
