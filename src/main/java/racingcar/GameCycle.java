package racingcar;

import java.util.ArrayList;

public class GameCycle {
	final private int repetitionTime;
	final private ArrayList<Car> participatedCar = new ArrayList<Car>();

	public GameCycle(String[] carInformation, int repetitionTime){
		this.repetitionTime = repetitionTime;
		SettingGame(carInformation);
	}

	private void SettingGame(String[] carInformation){
		for(int i = 0; i<carInformation.length; i++){
			participatedCar.add(new Car(carInformation[i]));
		}
		//test
		for(Car test : participatedCar){
			test.Print();
		}
	}

	private void GameStart(){
		for(int turn = 0; turn < repetitionTime; turn++){
			
		}
	}

}
