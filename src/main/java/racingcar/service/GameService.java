package racingcar.service;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.CarDto;
import racingcar.domain.Game;
import racingcar.repository.GameRepository;

public class GameService {
	private static final int START_INCLUSIVE = 0;
	private static final int END_INCLUSIVE = 9;
	private static final int FORWARD_CONDITION = 4;
	private static final int MIN_VALUE = -1;
	private final GameRepository gameRepository = new GameRepository();

	public List<CarDto> play(Long id) {
		Game game = gameRepository.findById(id);
		while (!game.checkReachTrialNumToTrial()) {
			moveForwardByRandomNumber(game);
			game.increaseTrialNum();
		}
		return getDto(game.getCars());
	}

	private List<CarDto> getDto(List<Car> cars) {
		int maxPosition = getMaxPosition(cars);
		List<CarDto> carDtos = new ArrayList<>();
		for (Car car : cars) {
			CarDto carDto = new CarDto();
			setCarDto(car, carDto);
			if (car.getPosition() == maxPosition) {
				carDto.setWin(true);
			}
			carDtos.add(carDto);
		}
		return carDtos;
	}

	private void setCarDto(Car car, CarDto carDto) {
		carDto.setName(car.getName());
		carDto.setPosition(car.getPosition());
		carDto.setWin(false);
	}

	private int getMaxPosition(List<Car> cars) {
		int max = MIN_VALUE;
		for (Car car : cars) {
			if (max < car.getPosition()) {
				max = car.getPosition();
			}
		}
		return max;
	}

	public Long save(Game game) {
		return gameRepository.save(game);
	}

	private void moveForwardByRandomNumber(Game game) {
		for (Car car : game.getCars()) {
			if (FORWARD_CONDITION <= getRandomNumber()) {
				car.moveForward(1);
			}
		}
	}

	private int getRandomNumber() {
		return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
	}
}
