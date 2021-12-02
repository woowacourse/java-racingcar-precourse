package racingcar;

import java.util.ArrayList;

import racingcar.input.NameReceiver;
import racingcar.input.TryCountReceiver;

public class GameHost {

	NameReceiver nameReceiver = new NameReceiver();
	TryCountReceiver tryCountReceiver = new TryCountReceiver();

	public void run() {
		// 자동차 이름 입력
		ArrayList<String> nameList = nameReceiver.receive();

		// 시도 횟수 입력
		Integer tryCount = tryCountReceiver.receive();
	}
}
