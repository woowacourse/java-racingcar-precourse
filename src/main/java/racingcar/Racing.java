package racingcar;

import java.util.ArrayList;

public class Racing {

	public ArrayList<Car> start(ArrayList<String> nameList, Integer tryCount) {
		ArrayList<Car> carList = makeCarList(nameList);

		for (int i = 0; i < tryCount; i++) {
			driveAllCars(carList);

			showAllPositions(carList);
			// 공백 라인 출력
			System.out.println();
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

	private void showAllPositions(ArrayList<Car> carList) {
		for (int i = 0; i < carList.size(); i++) {
			Car car = carList.get(i);

			System.out.println(car.getName() + " : " + car.showPosition());
		}
	}
}
