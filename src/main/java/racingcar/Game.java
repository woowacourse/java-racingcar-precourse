package racingcar;

import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.Message;
import racingcar.iomanagement.OutputPrinter;

public class Game {
	CarManager carManager = new CarManager();
	OutputPrinter outputPrinter = new OutputPrinter();

	public void startGame() {
		System.out.println(Message.CAR_INPUT);
		String carNames = Console.readLine();
		List<Car> carList = carManager.generate(carNames);

		System.out.println(Message.NUMBER_OF_ATTEMPTS);
		long count = Long.parseLong(Console.readLine());

		System.out.println(Message.EXECUTION_RESULT);
		for (int i = 0; i < count; i++) {
			carList = updateCarListPosition(carList);
			carList.forEach(car -> outputPrinter.printStepResult(car));
			System.out.println();
		}

		List<Car> winnerCarList = carManager.getWinner(carList);
		outputPrinter.printFinalWinner(winnerCarList);
	}

	public List<Car> updateCarListPosition(List<Car> carList) {
		return carList.stream()
			.map(this::updateCarRandom)
			.collect(Collectors.toList());
	}

	private Car updateCarRandom(Car car) {
		int randomNumber = Randoms.pickNumberInRange(0, 9);

		if (randomNumber > 4 || randomNumber == 4) {
			car.updatePosition();
		}

		return car;
	}
}
