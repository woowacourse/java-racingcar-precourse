package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.utils.Constant;
import racingcar.utils.ExceptionMessage;
import racingcar.view.InputView;

public class InputController {

	public Cars getInput_Car() {
		Cars carList;
		while (true) {
			String[] carName = InputView.getCarNames();
			try {
				carList = new Cars(carName);
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		return carList;
	}

	public int validateType_tryNum() {
		try {
			int tryNum = Integer.parseInt(InputView.getTryNum());
			return tryNum;
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(ExceptionMessage.TRY_TYPE_FAIL);
		}
	}

	public void validateRange_tryNum(int tryNum) {
		if (tryNum < Constant.TRY_NUM_RANGE_LIMIT) {
			throw new IllegalArgumentException(ExceptionMessage.TRY_RANGE_FAIL);
		}
	}
}