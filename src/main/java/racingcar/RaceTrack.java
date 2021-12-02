package racingcar;

import java.util.ArrayList;

public class RaceTrack {

	private static final String RACING_RESULT_MESSAGE = "실행 결과";

	public ArrayList<Car> start(ArrayList<String> nameList, Integer tryCount) {
		System.out.println(RACING_RESULT_MESSAGE);

		ArrayList<Car> carList = makeCarList(nameList);

		for (int i = 0; i < tryCount; i++) {
			driveAllCars(carList);
			showAllPositions(nameList, carList);
		}

		return carList;
	}

	private ArrayList<Car> makeCarList(ArrayList<String> nameList) {
		ArrayList<Car> carList = new ArrayList<>();

		for (String name : nameList) {
			carList.add(new Car(name));
		}

		return carList;
	}

	private void driveAllCars(ArrayList<Car> carList) {
		for (int i = 0; i < carList.size(); i++) {
			carList.get(i).drive();
		}
	}

	private void showAllPositions(ArrayList<String> nameList, ArrayList<Car> carList) {
		for (int i = 0; i < carList.size(); i++) {
			String name = nameList.get(i);
			Car car = carList.get(i);

			System.out.println(name + " : " + car.showPosition());
		}

		// 공백 라인 출력
		System.out.println();
	}
}
