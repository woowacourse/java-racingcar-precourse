package racingcar.winner;

import java.util.ArrayList;
import java.util.Collections;

import racingcar.car.Car;
import racingcar.car.CarRepository;

public class WinnerListService {
	CarRepository carRepository;

	public WinnerListService(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	public WinnerList setWinner() {
		WinnerList winnerList = new WinnerList();
		setWinnerPosition(winnerList);
		checkIsWinnerCar(winnerList);
		return winnerList;
	}

	private void setWinnerPosition(WinnerList winnerList) {
		ArrayList<Integer> positions = new ArrayList<>();
		for (Car car : carRepository.getCars()) {
			positions.add(car.getPosition());
		}
		int winnerPosition = Collections.max(positions);
		winnerList.setWinnerPosition(winnerPosition);
	}

	//모든 차에 대해서 우승여부 확인
	private void checkIsWinnerCar(WinnerList winnerList) {
		for (Car car : carRepository.getCars()) {
			addWinnerCar(car, winnerList);
		}
	}

	//우승 자동차 목록에 추가
	private void addWinnerCar(Car car, WinnerList winnerList) {
		int carPosition = car.getPosition();
		int winnerPosition = winnerList.getWinnerPosition();
		if (carPosition == winnerPosition) {
			winnerList.addWinnerCarList(car);
		}
	}
}
