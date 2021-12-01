package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import racingcar.Car;
import racingcar.util.RandomNumberGenerator;

public class Racing {
	private final int PIVOT = 4;
	private final String RESULT_START_MESSAGE = "실행 결과";
	private final String RESULT_WINNER_MESSAGE = "최종 우승자 : %s";

	private RandomNumberGenerator randomNumberGenerator;
	private ArrayList<Car> cars;
	private int moveNum;

	public Racing(List<String> names, int moveNum) {
		this.cars = createCarList(names);
		this.moveNum = moveNum;
	}

	public void startRacing(){
		System.out.println(RESULT_START_MESSAGE);
		for (int round = 0; round < moveNum; ++round) {
			moveAndPrintCurrentPosition();
		}
		System.out.printf(RESULT_WINNER_MESSAGE,findWinner());
	}

	private ArrayList<Car> createCarList(List<String> names){
		cars = new ArrayList<>();
		for(String name : names){
			cars.add(new Car(name));
		}
		return cars;
	}

	private void moveAndPrintCurrentPosition(){
		for(Car car : cars){
			if(randomNumberGenerator.generateRandomNumber() >= PIVOT){
				car.moveAhead();
			}
			car.printCurrentPosition();
		}
		System.out.println();
	}

	private String findWinner(){
		int winnerPosition = cars.stream().mapToInt(car -> car.currentPosition()).max().getAsInt();
		ArrayList<String> winners = new ArrayList<>();
		for(Car car : cars){
			if(car.isWinner(winnerPosition)){
				winners.add(car.getName());
			}
		}
		return String.join(",",winners);
	}


}
