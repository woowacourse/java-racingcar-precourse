package racingcar.game;

import racingcar.car.Cars;
import racingcar.userinterface.Input;

public class Game {
	public void run() {
		Input input = new Input();
		Cars cars = new Cars();
		input.getCarNameList().forEach(cars::appendCar);
	}
	// 작업해야 하는 내용
	// 1. 라운드 작성 : 리스트 내에 있는 모든 자동차에 대해 주사위굴려서 전진시키기 + 결과 출력
	// 2. 우승자 출력 : 우승자 출력... 함수는... 이미 만들어두긴 했는데.
}
