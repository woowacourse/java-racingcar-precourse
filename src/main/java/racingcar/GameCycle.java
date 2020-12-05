package racingcar;

import outpututils.Print;

import java.util.ArrayList;

public class GameCycle {
	final private int repetitionTime;
	final private ArrayList<Car> participatedCar = new ArrayList<Car>();
	private int victoryScore = 0;

	public GameCycle(String[] carInformation, int repetitionTime) {
		this.repetitionTime = repetitionTime;
		SetGame(carInformation);
		GameStart();
	}

	private void SetGame(String[] carInformation) {
		for (int i = 0; i < carInformation.length; i++) {
			participatedCar.add(new Car(carInformation[i]));
		}
	}

	private void GameStart() {
		System.out.println("\n실행결과");
		for (int turn = 0; turn < repetitionTime; turn++) {
			TurnManagement();
			Print.PrintResult(participatedCar);
		}
		GameEnd();
	}

	private void GameEnd(){
		ArrayList<String> winners = new ArrayList<String>();
		FindVictoryScore();
		Print.PrintWinner(FindWinner(winners));
	}

	private void TurnManagement() {
		for (Car player : participatedCar) {
			player.StopOrGo();
		}
	}

	private ArrayList<String> FindWinner(ArrayList<String> winners){
		for(Car player : participatedCar){
			winners.add(CheckWinner(player));
		}
		return winners;
	}

	private String CheckWinner(Car player){
		if(player.GetPosition() == victoryScore){
			return player.GetName();
		}
		return null;
	}

	private void FindVictoryScore(){
		for(Car player : participatedCar){
			CheckVictoryScore(player.GetPosition());
		}
	}

	private void CheckVictoryScore(int playerScore){
		if(playerScore > victoryScore){
			victoryScore = playerScore;
		}
	}
}
