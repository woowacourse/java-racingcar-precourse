package racingcar.view;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Car;
import racingcar.utils.Message;
import racingcar.utils.Validation;

public class InputView {
	private static ArrayList<Car> carsList = new ArrayList<Car>();

	public static ArrayList<Car> getCarsList() {
		String carNames = carNamesInput();
		String[] carsArray = carNames.split(",");

		createCarsList(carsArray);
		return carsList;
	}

	public static String carNamesInput() {
		System.out.println(Message.ASK_CAR_NAMES);
		String carNames = Console.readLine();
		return carNames;
	}

	public static void createCarsList(String[] carsArray) {
		for (int i = 0; i < carsArray.length; i++) {
			carsList.add(new Car(carsArray[i]));
		}
	}

	public static int getGameCount() {
		System.out.println(Message.ASK_GAME_COUNT);
		String stringGameCount = Console.readLine();
		System.out.println();
		int gameCount = gameCountParser(stringGameCount);
		return gameCount;
	}

	public static int gameCountParser(String stringGameCount) {
		int gameCount = Integer.parseInt(stringGameCount);
		return gameCount;
	}

	public static boolean checkRightNames(String [] carsArray){
		boolean isRightNames = true;
		try{
			Validation.LESS_MORE_NAME_ERROR(carsArray);
			Validation.CONTAIN_SAME_NAME_ERROR(carsArray);
			Validation.WHITE_SPACE_NAME_ERROR(carsArray);
		} catch (IllegalArgumentException e){
			System.out.println(e.getMessage());
			isRightNames = false;
		}
		return isRightNames;
	}

	public static boolean checkRightGameCount(String stringGameCount){
		boolean isRightNumeric = true;
		try{
			Validation.NON_NUMERIC_GAME_COUNT_ERROR(stringGameCount);
			Validation.ZERO_GAME_COUNT_ERROR(stringGameCount);
		} catch (NumberFormatException e){
			System.out.println(e.getMessage());
			isRightNumeric = false;
		}
		return isRightNumeric;
	}

}
