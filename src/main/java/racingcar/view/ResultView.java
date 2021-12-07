package racingcar.view;

import static racingcar.constant.StringConstant.*;

import racingcar.car.Car;
import racingcar.car.CarRepository;

public class ResultView implements View {
	private boolean isInit = true;
	private CarRepository carRepository;

	public ResultView(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	@Override
	public void printView() {
		if (isInit) {
			printInitView();
			isInit = false;
		}
		for (Car car : carRepository.getCars()) {
			printResult(car);
		}
		System.out.println();
	}

	private void printInitView() {
		System.out.println(RESULT_INIT_MESSAGE);
	}

	//자동차의 position에 따라 결과 메세지 출력
	private void printResult(Car car) {
		String carName = car.getName();
		int carPosition = car.getPosition();
		String result = carName + CAR_RESULT_DIVIDER;
		for (int i = 0; i < carPosition; i++) {
			result += MOVE_RESULT;
		}
		System.out.println(result);
	}
}
