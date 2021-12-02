package racingcar;

import java.util.ArrayList;

public class Referee {
	private ArrayList<Car> carList;

	Referee(ArrayList<Car> carList){
		this.carList = carList;
	}

	void makeJudgement(){
		makeWinnerList();
		printWinner();
	}

	void makeWinnerList(){
		for (Car car : carList){
			pickWinner(car);
		}
	}

	int maxPosition = 0;

	void pickWinner(Car car){
		int position = car.getPosition();

		if (maxPosition < position){
			maxPosition = position;
			initWinnerList(car);

		} else if (maxPosition == position){
			winnerNameList.add(car.getName());
		}
	}

	private ArrayList<String> winnerNameList;

	void initWinnerList(Car car){
		winnerNameList = new ArrayList<String>() {{
			add(car.getName());
		}};
	}

	void printWinner(){
		String winnerList = String.join(", ", winnerNameList);
		System.out.printf("최종 우승자 : %s", winnerList);
	}

}
