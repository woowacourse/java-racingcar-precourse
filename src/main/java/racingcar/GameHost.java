package racingcar;

import java.util.ArrayList;

import racingcar.input.NameReceiver;

public class GameHost {

	NameReceiver nameReceiver = new NameReceiver();

	public void run() {
		// 자동차 이름 입력
		ArrayList<String> nameList = nameReceiver.receive();
	}
}
