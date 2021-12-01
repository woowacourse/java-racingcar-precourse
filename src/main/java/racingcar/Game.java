package racingcar;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;
import config.ErrorMessage;
import config.Message;

public class Game {
	private static ArrayList<Car> cars = new ArrayList<>();
	private static int repeatNumber;
	private static Message message = new Message();
	private static ErrorMessage errorMessage = new ErrorMessage();

	public void play() {
		InputCars();
		InputRepeatNumber();
	}

	private void InputCars() {
		System.out.println(message.getENTER_CARS_NAME());
		String inputStr = Console.readLine();

		try {
			checkInputCarsName(inputStr.split(","));
		} catch (IllegalArgumentException e) {
			System.out.println(errorMessage.getCAR_NAME_LENGTH_ERROR());
			InputCars();
		}
	}

	private void checkInputCarsName(String[] carsStr) throws IllegalArgumentException {
		for (String car : carsStr) {
			if (car.length() > 5) {
				throw new IllegalArgumentException();
			}
			addCarinList(car);
		}
	}

	private void addCarinList(String car) {
		cars.add(new Car(car));
	}

	private void InputRepeatNumber() {
		System.out.println(message.getASK_REPEAT_NUM());
		String inputStr = Console.readLine();
		try{
			checkInputRepeatNumber(inputStr);

		} catch (IllegalArgumentException e){
			System.out.println(errorMessage.getNOT_CORRECT_REPEAT_NUM_ERROR());
			InputRepeatNumber();
		}
	}

	private void checkInputRepeatNumber(String inputStr) throws IllegalArgumentException {
		for(char c: inputStr.toCharArray()){
			if(!Character.isDigit(c)){
				throw new IllegalArgumentException();
			}
		}
		repeatNumber = Integer.parseInt(inputStr);
	}









}
