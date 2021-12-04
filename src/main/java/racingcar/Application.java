package racingcar;

import java.util.ArrayList;

public class Application {
	public static void main(String[] args) {
		ArrayList<Car> carList = new CarListMaker().getCarList();
		int repeatNum = new RepeatNumMaker().getRepeatNum();
		carList = new Race(carList, repeatNum).getCarList();
		Referee referee = new Referee(carList);
		referee.makeJudgement();
	}
}
