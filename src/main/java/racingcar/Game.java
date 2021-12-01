package racingcar;

import static camp.nextstep.edu.missionutils.Console.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
	private static final String GET_CARS_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String GET_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

	public int gameCount;
	public Cars carList;

	public static String generateUserInput() {
		String userInput;
		userInput = readLine();

		return userInput;
	}

	public static List<String> strToList(String str) {
		String[] strSplited = str.split(",");
		List<String> list;
		list = new ArrayList<>(Arrays.asList(strSplited));

		return list;
	}

	public static void runGameByCar(Car drivingCar) {
		int randomNo = new GenerateRandomNo().randomNo;
		if (Car.isForward(randomNo)) {
			drivingCar.forward();
		}
		System.out.println(drivingCar.getName() + " : " + drivingCar.getScoreString());
	}

	public static void runGameOneStep(Cars carList) {
		for (Car car : carList.cars) {
			runGameByCar(car);
		}
		System.out.println();
	}

	public static void printWinners(Cars carList) {
		List<String> winnerList = carList.getWinner();
		String winnerMessage = "최종 우승자 : ";

		for (String winner : winnerList) {
			winnerMessage += winner;
			winnerMessage += ",";
		}
		System.out.print(winnerMessage.substring(0, winnerMessage.length() - 1));
	}

	public static void runGame() {
		Game newGame = new Game();
		newGame.generateCars();
		newGame.getGameCount();
		System.out.println("\n실행 결과");

		for (int i = 0; i < newGame.gameCount; i++) {
			runGameOneStep(newGame.carList);
		}
		printWinners(newGame.carList);
	}

	public void generateCars() {
		List<String> userInput;
		do {
			System.out.println(GET_CARS_MESSAGE);
			userInput = strToList(generateUserInput());
		} while (!ValidationUtils.validCarList(userInput));
		Cars carList;
		carList = new Cars(userInput);

		this.carList = carList;
	}

	public void getGameCount() {
		String input;
		do {
			System.out.println(GET_COUNT_MESSAGE);
			input = generateUserInput();
		} while (!ValidationUtils.validNumber(input));
		this.gameCount = Integer.parseInt(input);
	}
}
