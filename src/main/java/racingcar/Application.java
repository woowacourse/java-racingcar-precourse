package racingcar;

import java.util.ArrayList;

public class Application {
	public static void main(String[] args) {
		ArrayList<Car> carList = new CarListMaker().getCarList();
		int repeatNum = new RepeatNumMaker().getRepeatNum();
		Race race = new Race(carList, repeatNum);
		Referee referee = new Referee(carList);
		referee.makeJudgement();
	}
}