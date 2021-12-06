package racingcar.view;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Car;
import racingcar.utils.Message;

public class InputView {

	public static ArrayList<Car> carsList(){
		ArrayList<Car> carsList = new ArrayList<Car>();
		String carNames = carNamesInput();

		String [] carsArray = carNames.split(",");
		for (int i = 0; i < carsArray.length; i++){
			carsList.add(new Car(carsArray[i]));
		}
		return carsList;
	}

	public static String carNamesInput() {
		System.out.println(Message.ASK_CAR_NAMES);
		String carNames = Console.readLine();
		return carNames;
	}

	public static int gameCount(){
		System.out.println(Message.ASK_GAME_COUNT);
		String stringGameCount = Console.readLine();
		int gameCount = gameCountParser(stringGameCount);
		return gameCount;
	}

	public static int gameCountParser(String stringGameCount){
		int gameCount = Integer.parseInt(stringGameCount);
		return gameCount;
	}

}
