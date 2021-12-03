package racingcar.application;

import static racingcar.domain.Judge.*;
import static racingcar.utils.Input.*;
import static racingcar.utils.Output.*;
import static racingcar.utils.RandomNumberBox.*;

import racingcar.domain.Car;

public class GameLauncher {

	static {
		INPUT_INSTANCE.initInputInstance(RANDOM_NUMBER_BOX_INSTANCE);
		OUTPUT_INSTANCE.initOutputInstance(JUDGE_INSTANCE);
	}

	public static void run(){
		String[] carNames = INPUT_INSTANCE.inputCarNames();
		Car[] cars = INPUT_INSTANCE.inputCarNameToCarObj(carNames);

		int coin = INPUT_INSTANCE.inputCoinNumber();

		while (coin-- > 0) {
			INPUT_INSTANCE.inputRandomNumberToCar(cars);
			OUTPUT_INSTANCE.outputCarPosition(cars);
		}

		OUTPUT_INSTANCE.outputRaceResult(cars);

	}
}
