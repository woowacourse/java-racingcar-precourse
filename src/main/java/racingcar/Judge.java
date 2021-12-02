package racingcar;

import java.util.ArrayList;
import java.util.Arrays;

public class Judge {

	private static final String WINNER_MESSAGE = "최종 우승자 : ";

	public void announceWinner(ArrayList<String> nameList, ArrayList<Car> carList) {
		int max = carList.stream()
			.map(x -> x.showPosition().length())
			.mapToInt(x -> Integer.valueOf(x))
			.max()
			.getAsInt();

		ArrayList<String> winnerList = makeWinnerList(nameList, carList, max);

		System.out.println(makeWinnerMessage(winnerList));
	}

	private ArrayList<String> makeWinnerList(ArrayList<String> nameList, ArrayList<Car> carList, int max) {
		ArrayList<String> winnerList = new ArrayList<>();

		for (int i = 0; i < carList.size(); i++) {
			Car car = carList.get(i);

			if (car.showPosition().length() == max) {
				winnerList.add(nameList.get(i));
			}
		}

		return winnerList;
	}

	private String makeWinnerMessage(ArrayList<String> winnerList) {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(WINNER_MESSAGE);
		stringBuilder.append(winnerList.get(0));

		// 공동 우승일 경우
		for (int i = 1; i < winnerList.size(); i++) {
			stringBuilder.append(", " + winnerList.get(i));
		}

		return stringBuilder.toString();
	}
}
