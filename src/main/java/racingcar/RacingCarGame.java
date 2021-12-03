package racingcar;

import java.util.ArrayList;

import racingcar.domain.Car;
import racingcar.receiver.NameReceiver;
import racingcar.receiver.TryCountReceiver;
import racingcar.service.JudgeService;
import racingcar.service.RacingService;

public class RacingCarGame {

	private static final String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
	private static final String RACING_RESULT_MESSAGE = "실행 결과";
	private static final String WINNER_MESSAGE_PREFIX = "최종 우승자 : ";

	private ArrayList<String> nameList;
	private Integer tryCount;
	private ArrayList<Car> carList;
	private ArrayList<String> winnerList;

	public void run() {
		// 자동차 이름 입력
		inputCarName();

		// 시도 횟수 입력
		inputTryCount();

		System.out.println();

		// 레이싱 실행
		executeRacing();

		// 최종 우승자 발표
		announceWinner();
	}

	private void inputCarName() {
		System.out.println(INPUT_NAME_MESSAGE);

		nameList = new NameReceiver().receive();
	}

	private void inputTryCount() {
		System.out.println(INPUT_TRY_COUNT_MESSAGE);

		tryCount = new TryCountReceiver().receive();
	}

	private void executeRacing() {
		System.out.println(RACING_RESULT_MESSAGE);

		RacingService racingService = new RacingService();

		carList = racingService.start(nameList, tryCount);

		ArrayList<String> racingLog = racingService.getRacingLog();
		for (String str : racingLog) {
			System.out.println(str);
		}
	}

	private void announceWinner() {
		winnerList = new JudgeService().makeWinnerList(carList);

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(WINNER_MESSAGE_PREFIX);
		stringBuilder.append(winnerList.get(0));

		// 공동 우승일 경우
		for (int i = 1; i < winnerList.size(); i++) {
			stringBuilder.append(", " + winnerList.get(i));
		}

		System.out.println(stringBuilder.toString());
	}
}
