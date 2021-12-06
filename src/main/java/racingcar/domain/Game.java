package racingcar.domain;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Car;
import racingcar.utils.RandomGenerator;
import racingcar.view.InputView;

import static racingcar.utils.ConstantNum.*;

public class Game {

	public void play(){
		ArrayList<Car> carsList = InputView.carsList();
		int gameCount = InputView.gameCount();

		//랜덤 경기 진행
		race(carsList, gameCount);
		//우승자 선발

		//위너 출력
	}

	private void race(ArrayList<Car> carsList, int gameCount) {
		for (Car car : carsList){
			playTurn(car, gameCount);
		}
	}

	public void playTurn(Car car, int gameCount){
		for(int i = 0; i < gameCount; i++){
			car.proceedOrPause();
			car.printPosition();
		}
		System.out.println();
	}


}
