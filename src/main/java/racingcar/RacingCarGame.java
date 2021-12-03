package racingcar;

import java.util.ArrayList;

import racingcar.receiver.NameReceiver;
import racingcar.receiver.TryCountReceiver;
import racingcar.service.JudgeService;
import racingcar.service.RacingService;
import racingcar.util.View;

public class RacingCarGame {

	public void run() {
		// 자동차 이름 입력
		View.printNameInputView();
		ArrayList<String> nameList = new NameReceiver().receive();

		// 시도 횟수 입력
		View.printTryNumberInputView();
		Integer tryCount = new TryCountReceiver().receive();

		View.printBlankLineView();

		// 레이싱 실행
		View.printRacingStartView();
		RacingService racingService = new RacingService();
		ArrayList<Car> carList = racingService.start(nameList, tryCount);
		View.printRacingLogView(racingService.getRacingLog());

		// 최종 우승자 발표
		ArrayList<String> winnerList = new JudgeService().makeWinnerList(carList);
		View.printWinnerView(winnerList);
	}
}
