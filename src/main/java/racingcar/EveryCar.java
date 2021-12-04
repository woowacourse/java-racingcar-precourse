package racingcar;

import java.util.ArrayList;
import java.util.Arrays;

import racingcar.dto.CarDTO;
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
		ArrayList<CarDTO> carsDTO = new ArrayList<>();
		cars.stream().forEach(eachCar -> {
			eachCar.move();
			carsDTO.add(new CarDTO(eachCar.getName(), eachCar.showMovingDistance()));
		});
		OutputView.showResultThisTiming(carsDTO);
	}

	public void showThisGameWinner() {
		ArrayList<CarDTO> carsDTO = new ArrayList<>();
		cars.stream().forEach(eachCar -> carsDTO.add(new CarDTO(eachCar.getName(), eachCar.showMovingDistance())));
		OutputView.showThisGameWinner(carsDTO);
	}
}
