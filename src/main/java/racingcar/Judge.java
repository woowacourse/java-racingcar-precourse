package racingcar;

import java.util.ArrayList;

public class Judge {

	private static final String WINNER_MESSAGE_PREFIX = "최종 우승자 : ";

	public void announceWinner(ArrayList<Car> carList) {
		int max = carList.stream()
			.map(car -> car.showPosition().length())
			.mapToInt(length -> Integer.valueOf(length))
			.max()
			.getAsInt();

		ArrayList<String> winnerList = makeWinnerList(carList, max);

		String winnerMessage = makeWinnerMessage(winnerList);
		System.out.println(winnerMessage);
	}

	private ArrayList<String> makeWinnerList(ArrayList<Car> carList, int max) {
		ArrayList<String> winnerList = new ArrayList<>();

		for (int i = 0; i < carList.size(); i++) {
			Car car = carList.get(i);

			if (car.showPosition().length() == max) {
				winnerList.add(car.getName());
			}
		}

		return winnerList;
	}

	private String makeWinnerMessage(ArrayList<String> winnerList) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(WINNER_MESSAGE_PREFIX);
		stringBuilder.append(winnerList.get(0));

		// 공동 우승일 경우
		for (int i = 1; i < winnerList.size(); i++) {
			stringBuilder.append(", " + winnerList.get(i));
		}

		return stringBuilder.toString();
	}
}
