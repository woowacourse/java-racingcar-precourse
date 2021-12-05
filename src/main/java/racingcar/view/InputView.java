package racingcar.view;

import racingcar.domain.Cars;

public class InputView {

	public static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	public static final String INPUT_TRY_NUMBERS = "시도할 회수는 몇회인가요?";

	private final InputStrategy inputStrategy;

	public InputView(InputStrategy inputStrategy) {
		this.inputStrategy = inputStrategy;
	}

	public ViewDto input() {
		System.out.println(INPUT_CAR_NAMES);
		Cars cars = inputStrategy.getCars();
		System.out.println(INPUT_TRY_NUMBERS);
		int tryNumber = inputStrategy.getTryNumber();
		return new ViewDto(cars, tryNumber);
	}

}