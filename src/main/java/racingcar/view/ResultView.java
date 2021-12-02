package racingcar.view;

import racingcar.car.Car;
import racingcar.car.CarRepository;

public class ResultView implements View {
	private boolean isInit = true;
	private final String INIT_MESSAGE = "\n실행 결과";
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

	@Override
	public String getUserInput() {
		return null;
	}

	private void printInitView() {
		System.out.println(INIT_MESSAGE);
	}

	//자동차의 position에 따라 결과 메세지 출력
	private void printResult(Car car) {
		String carName = car.getName();
		int carPosition = car.getPosition();
		String result = carName + " : ";
		for (int i = 0; i < carPosition; i++) {
			result += "-";
		}
		System.out.println(result);
	}
}
