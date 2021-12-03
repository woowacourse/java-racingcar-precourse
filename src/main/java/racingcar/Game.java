package racingcar;

import java.util.ArrayList;

import racingcar.utils.Constant;

public class Game {

	public void play() {
		ArrayList<Car> carsList = getCarsList();
		int gameCount = getGameCount();

		System.out.println(Constant.PLAY_RESULT);
		for(int i = 0; i < gameCount; i++) {
			playTurn(carsList);
		}

		pickWinner(carsList);
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

	public void pickWinner(ArrayList<Car> carsList){
		ArrayList<Car> winnerList = new ArrayList<Car>();
		int maxValue = getMaxValue(carsList);
		for(Car car : carsList){
			if(car.getPosition() == maxValue){
				winnerList.add(car);
			}
		}
		printWinner(winnerList);
	}

	public int getMaxValue(ArrayList<Car> carsList){
		int maxValue = 0;
		for(int i = 0; i < carsList.size(); i++){
			if (maxValue < carsList.get(i).getPosition()){
				maxValue = carsList.get(i).getPosition();
			}
		}
		return maxValue;
	}

	public void printWinner(ArrayList<Car> winnerList){
		System.out.print(Constant.WINNER);
		for (int i = 0; i < winnerList.size(); i++) {
			System.out.print(String.join(", ", winnerList.get(i).getCarName()));
		}
	}
}