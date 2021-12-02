package racingcar;

import java.util.ArrayList;
import java.util.List;

import racingcar.handler.InputHandler;
import racingcar.handler.PrintHandler;

public class Game {
	private final List<Car> carList;
	private int runNumber;

	public Game() {
		this.carList = new ArrayList<>();
	}

	public void run() {
		inputName();
		inputRunNumber();
		PrintHandler.printResultMsg();
		for (int i = 0; i < runNumber; i++) {
			playOnce();
		}
	}

	private void inputName() {
		PrintHandler.printInputNameMsg();
		try {
			String[] names = InputHandler.getNameInput();
			createCar(names);
		} catch (IllegalArgumentException e) {
			PrintHandler.printErrorMsg(e);
			inputName();
		}
	}

	private void createCar(String[] names) {
		for (String name : names) {
			Car car = new Car(name.trim());
			carList.add(car);
		}
	}

	private void inputRunNumber() {
		PrintHandler.printInputNumberMsg();
		try {
			this.runNumber = InputHandler.getNumberInput();
		} catch (IllegalArgumentException e) {
			inputRunNumber();
		}
	}

	private void playOnce() {
		carList.forEach(Car::playOnce);
		PrintHandler.printBlank();
	}
}
