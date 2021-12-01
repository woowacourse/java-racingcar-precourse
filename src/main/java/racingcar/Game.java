package racingcar;

import java.util.ArrayList;
import java.util.Collections;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import config.ErrorMessage;
import config.Message;

public class Game {
	private static Message message = new Message();
	private static ErrorMessage errorMessage = new ErrorMessage();
	private static ArrayList<Car> cars;
	private static int repeatNumber;

	public void play() {
		inputCars();
		inputRepeatNumber();
		getResult();
		getWinner();
	}

	//TODO: inputCars() 랑 inputRepeatNumber() 한 메서드로 합치기
	private void inputCars() {
		cars= new ArrayList<>();
		System.out.println(message.getENTER_CARS_NAME());
		String inputStr = Console.readLine();

		try {
			checkNull(inputStr);
			checkInputCarsNameLen(inputStr.split(","));

		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR] "+e.getMessage());
			inputCars();
		}
	}

	private void inputRepeatNumber() {
		System.out.println(message.getASK_REPEAT_NUM());
		String inputStr = Console.readLine();

		try {
			checkNull(inputStr);
			checkInputRepeatNumber(inputStr);

		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR] "+e.getMessage());
			inputRepeatNumber();
		}
	}

	// 결과 알려주기
	private void getResult() {
		System.out.println(message.getPRINT_RESULT());
		for (int i = 0; i < repeatNumber; i++) {
			decideMoveOrStop();
			checkSorting(i);
			System.out.println();
		}
	}

	private void decideMoveOrStop() {
		for (int i = 0; i < cars.size(); i++) {
			compareRandomNum(i);
		}
	}

	private void compareRandomNum(int carIdx) {
		if (Randoms.pickNumberInRange(0, 9) >= 4) {
			cars.get(carIdx).addPosition();
		}
		printResult(carIdx);
	}

	private void printResult(int carIdx) {
		Car car = cars.get(carIdx);
		System.out.print(car.getName() + " : ");
		for (int i = 0; i < car.getPosition(); i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	private void checkSorting(int idx) {
		if (idx == repeatNumber - 1) {
			Collections.sort(cars);
		}
	}

	// 최종 우승자 알려주기
	private void getWinner() {
		System.out.print(message.getENTER_WINNER());
		int idx = checkNumberOfWinner();
		for (int i = 0; i < idx; i++) {
			System.out.print(cars.get(i).getName());
			checkAddComma(i,idx);
		}
	}

	private int checkNumberOfWinner() {
		int winnerNum = 1;
		Car maxPosCar = cars.get(0);
		for (int i = 1; i < cars.size(); i++) {
			if (cars.get(i).getPosition() != maxPosCar.getPosition()) {
				break;
			}
			winnerNum++;
		}

		return winnerNum;
	}

	private void checkAddComma(int idx, int len) {
		if (idx < len - 1) {
			System.out.print(", ");
		}
	}

	//TODO: validation Class 로 빼기
	private void checkInputCarsNameLen(String[] carsStr) {
		for (String car : carsStr) {
			if (car.length() > 5) {
				throw new IllegalArgumentException(errorMessage.getCAR_NAME_LENGTH_ERROR());
			}
			cars.add(new Car(car));
		}
	}

	//TODO: validation Class 로 빼기
	private void checkNull(String inputStr) {
		if (inputStr.length() == 0) {
			throw new IllegalArgumentException(errorMessage.getNULL_ERROR());
		}
	}

	//TODO: validation Class 로 빼기
	private void checkInputRepeatNumber(String inputStr)  {
		for (char c : inputStr.toCharArray()) {
			if (!Character.isDigit(c)) {
				throw new IllegalArgumentException(errorMessage.getNOT_CORRECT_REPEAT_NUM_ERROR());
			}
		}
		repeatNumber = Integer.parseInt(inputStr);
	}

	// TODO: 음의 정수 일 때 error 추가
}
