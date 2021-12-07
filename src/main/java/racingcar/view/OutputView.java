package racingcar.view;

import java.util.ArrayList;

import static racingcar.utils.Message.*;

public class OutputView {

	public void printPosition(String carName, int position) {
		System.out.print(carName + " : ");
		for (int i = 0; i < position; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	public void printWinner(ArrayList<String> stringWinnerList) {
		System.out.print(FINAL_WINNER + String.join(", ", stringWinnerList));
	}
}
