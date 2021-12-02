package racingcar;

import static racingcar.utils.Constant.*;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Printer;

public class Game {
	private final List<Car> carList;

	public Game() {
		this.carList = new ArrayList<>();
	}

	public void run() {
		inputName();
	}

	private void inputName() {
		Printer.printInputNameMsg();
		String[] names = Console.readLine().split(",");
		validateNameLength(names);
		createCar(names);
	}

	private void validateNameLength(String[] names) {
		for (String name : names) {
			if (name.trim().length() > NAME_LENGTH_LIMIT) {
				throw new IllegalArgumentException(ERROR_LENGTH_MSG);
			}
		}
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
