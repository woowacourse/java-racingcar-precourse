package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import racingcar.Car;
import racingcar.util.RandomNumberGenerator;

public class Racing {
	private final int PIVOT = 4;

	private RandomNumberGenerator randomNumberGenerator;
	private ArrayList<Car> cars;
	private int moveNum;

	public Racing(List<String> names, int moveNum) {
		this.cars = createCarList(names);
		this.moveNum = moveNum;
	}

	public void startRacing(){
		for (int i = 0; i < moveNum; ++i) {
			move();
		}
	}

	private ArrayList<Car> createCarList(List<String> names){
		cars = new ArrayList<>();
		for(String name : names){
			cars.add(new Car(name));
		}
		return cars;
	}

	private void move(){
		for(Car car : cars){
			if(randomNumberGenerator.generateRandomNumber() >= PIVOT){
				car.moveAhead();
			}
		}
	}

}
