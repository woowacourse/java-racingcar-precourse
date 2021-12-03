package racingcar;

import java.util.ArrayList;

import racingcar.utils.Constant;

public class Game {

	public void play() {
		ArrayList<Car> CarsList = getCarsList();
		int gameCount = getGameCount();

		System.out.println(Constant.PLAY_RESULT);
		for(int i = 0; i < gameCount; i++) {
			playTurn(CarsList);
		}
	}

	public ArrayList<Car> getCarsList() {
		User user = new User();

		ArrayList<Car> carsList = new ArrayList<Car>();

		String[] driverNamesInput = user.driverNameInput();

		for (int i = 0; i < driverNamesInput.length; i++) {
			carsList.add(new Car(driverNamesInput[i]));
		}
		return carsList;
	}

	public int getGameCount(){
		int gameCount = User.gameCountInput();
		return gameCount;
	}

	public void playTurn(ArrayList<Car> carsList){
		for (Car car : carsList){
			car.playTurn();
			car.printPosition();
		}
		System.out.println();
	}
}