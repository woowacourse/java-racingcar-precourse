package racingcar.view;

import java.util.List;

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
			printSteps(names[i], positions[i]);
		}

		System.out.println();
	}

	public static void printWinners(List<String> winnerList) {
		String winners = winnerList.toString().replace("[", "").replace("]", "");
		System.out.print("최종 우승자 : " + winners);
	}

	public static void printErrorMessage(Exception e) {
		System.out.println(e.getMessage());
	}

	private static void printSteps(String name, int position) {
		System.out.print(name + " : ");
		for (int j = 0; j < position; j++) {
			System.out.print(RacingCarConst.ONE_STEP);
		}
		System.out.println();
	}
}
