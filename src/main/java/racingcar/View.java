package racingcar;

import java.util.ArrayList;

public class View {

	private static final String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
	private static final String RACING_RESULT_MESSAGE = "실행 결과";
	private static final String WINNER_MESSAGE_PREFIX = "최종 우승자 : ";

	public static void printNameInputView() {
		System.out.println(INPUT_NAME_MESSAGE);
	}

	public static void printTryNumberInputView() {
		System.out.println(INPUT_TRY_COUNT_MESSAGE);
	}

	public static void printRacingView() {
		System.out.println(RACING_RESULT_MESSAGE);
	}

	public static void printWinnerView(ArrayList<String> winnerList) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(WINNER_MESSAGE_PREFIX);
		stringBuilder.append(winnerList.get(0));

		// 공동 우승일 경우
		for (int i = 1; i < winnerList.size(); i++) {
			stringBuilder.append(", " + winnerList.get(i));
		}

		System.out.println(stringBuilder.toString());
	}

	public static void printBlankLineView() {
		System.out.println();
	}
}
