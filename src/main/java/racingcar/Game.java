package racingcar;

import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
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
