package racingcar.view;

import java.util.ArrayList;

import racingcar.Car;

import static racingcar.utils.Message.*;

public class OutputView {

	private static ArrayList<String> stringWinnerNames = new ArrayList<String>();

	public static void printPosition(String carName, int position) {
		System.out.println(carName + " : ");
		for (int i = 0; i < position; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	public static void printWinner(ArrayList<Car> winnerList){
		stringWinnerNames = extractNames(winnerList);
		System.out.println(FINAL_WINNER);
		System.out.println(String.join(", ", stringWinnerNames));
	}

	public static ArrayList<String> extractNames(ArrayList<Car> winnerList){
		for(int i = 0; i < winnerList.size(); i++){
			stringWinnerNames.add(winnerList.get(i).getCarName());
		}
		return stringWinnerNames;
	}
}
