package racingcar;

import java.util.ArrayList;

import racingcar.repository.CarRepository;

public class Racing {

	public ArrayList<Car> start(ArrayList<String> nameList, Integer tryCount) {
		enrollCars(nameList);

		for (int i = 0; i < tryCount; i++) {
			driveAllCars(CarRepository.getCarList());

			showAllPositions(CarRepository.getCarList());
			// 공백 라인 출력
			System.out.println();
		}

		return CarRepository.getCarList();
	}

	private void enrollCars(ArrayList<String> nameList) {
		for (String name : nameList) {
			CarRepository.addCar(name);
		}
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
