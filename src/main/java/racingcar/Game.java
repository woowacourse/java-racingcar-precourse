package racingcar;

import java.util.ArrayList;

public class Game {

	public void play() {
		ArrayList<Car> driverNames = getDriverNames();
		int gameCount = getGameCount();
		playTurn(driverNames);
	}

	public ArrayList<Car> getDriverNames() {
		User user = new User();

		ArrayList<Car> driversList = new ArrayList<Car>();

		String[] driverNamesInput = user.driverNameInput();

		for (int i = 0; i < driverNamesInput.length; i++) {
			driversList.add(new Car(driverNamesInput[i]));
		}
		return driversList;
	}

	public int getGameCount(){
		int gameCount = User.gameCountInput();
		return gameCount;
	}

	public void playTurn(ArrayList<Car> driversList){
		for (Car car : driversList){
			car.playTurn();
		}
	}
}