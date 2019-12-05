import java.util.ArrayList;
import java.util.Collections;

import domain.Car;
import utils.InputHandler;
import view.InputView;

public class RacingGame {
	private ArrayList<Car> cars = new ArrayList<>();

	public void play() {
		buildCars();
	}

	private void buildCars() {
		ArrayList<String> carNames = getCarNames();
		for (String carName : carNames) {
			Car car = new Car(carName);
			cars.add(car);
		}
	}

	private ArrayList<String> getCarNames() {
		ArrayList<String> result = new ArrayList<>();
		String[] carNames = InputHandler.splitByComma(InputView.carNames());

		Collections.addAll(result, carNames);
		return result;
	}
}
