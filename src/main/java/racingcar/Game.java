package racingcar;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;

public class Game {
	static ArrayList<Car> cars = new ArrayList<>();

	public void play() {
		InputCars();
	}

	private void InputCars(){
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String inputStr = Console.readLine();
		try {
			checkInputCarsNameLength(inputStr.split(","));
		} catch (IllegalArgumentException e){
			System.out.println("[ERROR] 자동차 이름은 5자 이하만 가능하다.");
			InputCars();
		}
	}

	private void checkInputCarsNameLength(String[] carsStr) throws IllegalArgumentException {
		for(String car: carsStr){
			if(car.length()>5){
				throw new IllegalArgumentException();
			}
			addCarinList(car);
		}
	}

	private void addCarinList(String car){
		cars.add(new Car(car));
	}






}
