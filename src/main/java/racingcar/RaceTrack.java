package racingcar;

import java.util.ArrayList;

public class RaceTrack {

	private ArrayList<Car> makeCarList(ArrayList<String> nameList, ArrayList<Car> carList) {
		for (String name : nameList) {
			carList.add(new Car(name));
		}

		return carList;
	}
}
