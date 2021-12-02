package racingcar;

import java.util.ArrayList;
import java.util.List;

import racingcar.handler.InputHandler;
import racingcar.handler.PrintHandler;

public class Game {
	private final List<Car> carList;

	public Game() {
		this.carList = new ArrayList<>();
	}

	public void run() {
		try {
			inputName();
		} catch (IllegalArgumentException e) {
			PrintHandler.printErrorMsg(e);
			inputName();
		}
	}

	private void inputName() {
		PrintHandler.printInputNameMsg();
		String[] names = InputHandler.getNameInput();
		createCar(names);
	}

	private void createCar(String[] names) {
		for (String name : names) {
			Car car = new Car(name.trim());
			carList.add(car);
		}
	}

	public List<Car> getCarList() {
		return carList;
	}
}
