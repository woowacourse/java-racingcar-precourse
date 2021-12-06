package view;

public class Display {

	private Display() {
	}

	public static void pleaseInputRacingCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
	}

	public static void pleaseInputNumberOfCarRaces() {
		System.out.println("시도할 회수는 몇회인가요?");
	}

	public static void showExecutionResult() {
		System.out.println();
		System.out.println("실행 결과");
	}

	public static void showRacingCarNowPositions(String[] carNames, int[] carPositions) {
		System.out.println();
		for (int index = 0; index < carNames.length; index++) {
			showRacingCarName(carNames[index]);
			showRacingCarPosition(carPositions[index]);
		}
	}

	private static void showRacingCarName(String carName) {
		System.out.print(carName + " : ");
	}

	private static void showRacingCarPosition(int carPosition) {
		for (int index = 0; index < carPosition; index++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
