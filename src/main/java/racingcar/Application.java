package racingcar;

import java.util.ArrayList;

public class Application {
	public static void main(String[] args) {
		ArrayList<Car> carList = new CarListMaker().getCarList();
		int repeatNum = new RepeatNumMaker().getRepeatNum();
		new Race(carList).getResult(repeatNum);
		Referee referee = new Referee(carList);
		referee.makeJudgement();
	}
}
