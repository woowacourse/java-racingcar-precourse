package racingcar;

import outpututils.Print;
import utils.RandomUtils;

import java.util.ArrayList;

public class GameCycle {
	final private int repetitionTime;
	final private ArrayList<Car> participatedCar = new ArrayList<Car>();

	public GameCycle(String[] carInformation, int repetitionTime) {
		this.repetitionTime = repetitionTime;
		SetGame(carInformation);
		GameStart();
		/*test
		for(Car test : participatedCar){
			test.Print();
		}
		 */
	}

	private void SetGame(String[] carInformation) {
		for (int i = 0; i < carInformation.length; i++) {
			participatedCar.add(new Car(carInformation[i]));
		}
		/*test
		for(Car test : participatedCar){
			test.Print();
		}
		 */
	}

	private void GameStart() {
		System.out.println("\n실행결과");
		for (int turn = 0; turn < repetitionTime; turn++) {
			TurnManagement();
			Print.PrintResult(participatedCar);
		}
	}

	private void TurnManagement() {
		for (Car player : participatedCar) {
			player.StopOrGo();
		}
	}

}
