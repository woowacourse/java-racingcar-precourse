package racingcar;

import java.util.ArrayList;

import racingcar.receiver.NameReceiver;
import racingcar.receiver.TryCountReceiver;

public class GameHost {

	public void run() {
		// 자동차 이름 입력
		View.printNameInputView();
		ArrayList<String> nameList = new NameReceiver().receive();

		// 시도 횟수 입력
		View.printTryNumberInputView();
		Integer tryCount = new TryCountReceiver().receive();

		View.printBlankLineView();

		// 레이싱 실행
		View.printRacingView();
		ArrayList<Car> carList = new Racing().start(nameList, tryCount);

		// 최종 우승자 발표
		ArrayList<String> winnerList = new Judge().makeWinnerList(carList);
		View.printWinnerView(winnerList);
	}
}
