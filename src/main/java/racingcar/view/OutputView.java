package racingcar.view;

import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {

	public static final String OUTPUT_RESULT = "실행 결과";

	public static void printResult(ViewDto viewDto) {
		Cars cars = viewDto.getCars();
		int tryNumber = viewDto.getTryNumber();
		while (!cars.isEndGame(tryNumber)) {
			cars.move();
			cars.printPosition();
		};

	}
}
