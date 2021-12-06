package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;

import racingcar.dto.CarDto;
import racingcar.view.OutputView;

public class EveryCar {
	private final ArrayList<Car> cars = new ArrayList<>();

	public EveryCar(String[] carsName) {
		makeEveryCarInstance(carsName);
	}

	private void makeEveryCarInstance(String[] everyCarName) {
		Arrays.stream(everyCarName).forEach(eachCarName -> cars.add(new Car(eachCarName)));
	}

	public void moveEveryCarThisTiming() {
		ArrayList<CarDto> carsDto = new ArrayList<>();
		cars.forEach(eachCar -> {
			eachCar.move();
			carsDto.add(new CarDto(eachCar.getName(), eachCar.showMovingDistance()));
		});
		OutputView.showResultThisTiming(carsDto);
	}

	public void showThisGameWinner() {
		ArrayList<CarDto> carsDto = new ArrayList<>();
		cars.forEach(eachCar -> carsDto.add(new CarDto(eachCar.getName(), eachCar.showMovingDistance())));
		OutputView.showThisGameWinner(carsDto);
	}
}
