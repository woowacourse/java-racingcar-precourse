package racingcar.view;

import java.util.List;

import racingcar.domain.Car;
import racingcar.utils.Constant;

public class OutputView {

	public static void printRacingStart() {
		System.out.println(Constant.EXECUTION_RESULT);
	}

	public static void printWinner(List<Car> winnerList) {
		StringBuilder sb= new StringBuilder();
		sb.append(Constant.LAST_WINNER_IS);
		for(int i=0; i<winnerList.size(); i++) {
			if(i!=0) {
				sb.append(Constant.DELIMITER_CAR_NAME);
			}
			sb.append(winnerList.get(i).getName());
		}
		System.out.println(sb.toString());
	}

}