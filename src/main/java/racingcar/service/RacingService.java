package racingcar.service;

import java.util.ArrayList;

import racingcar.domain.Car;
import racingcar.repository.CarRepository;

public class RacingService {

	private ArrayList<String> racingLog = new ArrayList<>();

	public ArrayList<String> getRacingLog() {
		return this.racingLog;
	}

	public ArrayList<Car> start(ArrayList<String> nameList, Integer tryCount) {
		enrollCars(nameList);

		for (int i = 0; i < tryCount; i++) {
			driveAllCars(CarRepository.getCarList());
			writeLog(CarRepository.getCarList());
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

	private void writeLog(ArrayList<Car> carList) {
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < carList.size(); i++) {
			Car car = carList.get(i);
			stringBuilder.append(car.getName() + " : " + car.showPosition() + "\n");
		}
		stringBuilder.append("\n");

		racingLog.add(stringBuilder.toString());
	}
}
