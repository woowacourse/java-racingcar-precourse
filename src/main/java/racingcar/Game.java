package racingcar;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.Message;

public class Game {
	CarGenerator carGenerator = new CarGenerator();

	public void startGame() {
		System.out.println(Message.CAR_INPUT);
		String carNames = Console.readLine();
		List<Car> carList = carGenerator.generateCar(carNames);

		System.out.println(Message.NUMBER_OF_ATTEMPTS);
		long count = Long.parseLong(Console.readLine());

		for (int i = 0; i < count; i++) {
			//게임 진행 로직 구현
		}

		//List<Car>의 position 비교하여 최종 우승자 뽑는 로직 구현
	}
}
