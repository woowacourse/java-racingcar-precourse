package racingcar;

import java.util.ArrayList;

import racingcar.utils.RandomGenerator;

public class Game {
	public void play(){
		User user = new User();
		RandomGenerator randomGenerator = new RandomGenerator();
		ArrayList<Car> carArrayList = new ArrayList<Car>();

		String [] driverNames = user.driverNameInput();
		int gameCount = user.gameCountInput();


		//카 객체 생성
		for (int i = 0; i < driverNames.length; i++) {
			carArrayList.add(new Car(driverNames[i]));
		}
	}
}
