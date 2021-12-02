package racingcar;

import java.util.ArrayList;

import racingcar.input.NameReceiver;
import racingcar.input.TryCountReceiver;

public class GameHost {

	public void run() {
		// 자동차 이름 입력
		NameReceiver nameReceiver = new NameReceiver();
		ArrayList<String> nameList = nameReceiver.receive();

		// 시도 횟수 입력
		TryCountReceiver tryCountReceiver = new TryCountReceiver();
		Integer tryCount = tryCountReceiver.receive();

		// 레이싱 실행
		RaceTrack raceTrack = new RaceTrack();
		ArrayList<Car> carList = raceTrack.start(nameList, tryCount);

		// 최종 우승자 발표
		Judge judge = new Judge();
		judge.announceWinner(carList);
	}
}
