package racingcar;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import config.ErrorMessage;
import config.Message;

public class Game {
	private static Message message = new Message();
	private static ErrorMessage errorMessage = new ErrorMessage();
	private static ArrayList<Car> cars = new ArrayList<>();
	private static int repeatNumber;

	public void play() {
		inputCars();
		inputRepeatNumber();
		getResult();
	}

	private void inputCars() {
		System.out.println(message.getENTER_CARS_NAME());
		String inputStr = Console.readLine();

		try {
			checkInputCarsName(inputStr.split(","));
		} catch (IllegalArgumentException e) {
			System.out.println(errorMessage.getCAR_NAME_LENGTH_ERROR());
			inputCars();
		}
	}

	private void inputRepeatNumber() {
		System.out.println(message.getASK_REPEAT_NUM());
		String inputStr = Console.readLine();
		try {
			checkInputRepeatNumber(inputStr);

		} catch (IllegalArgumentException e) {
			System.out.println(errorMessage.getNOT_CORRECT_REPEAT_NUM_ERROR());
			inputRepeatNumber();
		}
	}

	private void getResult(){
		System.out.println(message.getPRINT_RESULT());
		for(int i=0; i<repeatNumber; i++){
			decideMoveOrStop();
			System.out.println();
		}
	}

	private void decideMoveOrStop(){
		for(int i=0; i<cars.size(); i++){
			compareRandomNum(i);
		}
	}

	private void compareRandomNum(int carIdx){
		if(Randoms.pickNumberInRange(0,9)>=4){
			cars.get(carIdx).addPosition();
		}
		printResult(carIdx);
	}

	private void printResult(int carIdx){
		Car car = cars.get(carIdx);
		System.out.print(car.getName()+ " : ");
		for(int i=0; i<car.getPosition(); i++){
			System.out.print("-");
		}
		System.out.println();
	}


	//TODO: validation Class 로 빼기
	private void checkInputCarsName(String[] carsStr) throws IllegalArgumentException {
		for (String car : carsStr) {
			if (car.length() > 5) {
				throw new IllegalArgumentException();
			}
			cars.add(new Car(car));
		}
	}

	//TODO: validation Class 로 빼기
	private void checkInputRepeatNumber(String inputStr) throws IllegalArgumentException {
		for (char c : inputStr.toCharArray()) {
			if (!Character.isDigit(c)) {
				throw new IllegalArgumentException();
			}
		}
		repeatNumber = Integer.parseInt(inputStr);
	}






}
