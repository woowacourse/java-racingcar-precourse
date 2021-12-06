package racingcar.domain;

import java.util.ArrayList;
import racingcar.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {

	private ArrayList<Car> carsList = new ArrayList<Car>();
	private int gameCount = 0;
	private int maxPosition = 0;
	private ArrayList<Car> winnerList = new ArrayList<Car>();

	public void play(){
		carsList = InputView.carsList();
		gameCount = InputView.gameCount();
		race(carsList, gameCount);
		pickWinner();
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

	public void pickWinner(){
		maxPosition = getMaxPosition();
		getWinnerList();
	}

	public int getMaxPosition(){
		for (int i = 0; i < carsList.size(); i++){
			if (maxPosition < carsList.get(i).getPosition()){
				maxPosition = carsList.get(i).getPosition();
			}
		}
		return maxPosition;
	}

	public void getWinnerList(){
		for (int i = 0; i < carsList.size(); i++) {
			if (maxPosition == carsList.get(i).getPosition()) {
				winnerList.add(carsList.get(i));
			}
		}
	}

	public void printWinner(){
		OutputView.printWinner(winnerList);
	}
}
