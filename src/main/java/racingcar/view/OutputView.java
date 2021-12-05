package racingcar.view;

import racingcar.constant.RacingCarConst;
import racingcar.domain.RacingCars;

public class OutputView {
	public static void printEnterCarNames() {
		System.out.println(RacingCarConst.ENTER_CAR_NAMES);
	}

	public static void printEnterStageNum() {
		System.out.println(RacingCarConst.ENTER_STAGE_NUM);
	}

	public static void printRacingStart() {
		System.out.println(RacingCarConst.RACING_START);
	}

	public static void printResult(RacingCars racingCars) {
		String[] names = racingCars.getNames();
		int[] positions = racingCars.getPositions();

		for (int i = 0; i < names.length; i++) {
			System.out.print(names[i] + " : ");
			for (int j = 0; j < positions[i]; j++) {
				System.out.print(RacingCarConst.ONE_STEP);
			}
			System.out.println();
		}

		System.out.println();
	}
}
