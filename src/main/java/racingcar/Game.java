package racingcar;

import java.util.ArrayList;
import java.util.Collections;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.controller.GameController;
import racingcar.exception.ErrorMessage;
import racingcar.exception.ErrorResponse;
import racingcar.message.Message;
import racingcar.domain.Car;
import racingcar.message.MessageResponse;

public class Game {
	// private static ArrayList<Car> cars;
	// private static int repeatNumber;

	private GameController gameController = new GameController();
	public void play() {
		gameController.inputCars();
		gameController.inputRepeatNumber();
		gameController.postResult();
		gameController.postWinner();
	}

	// //TODO: inputCars() 랑 inputRepeatNumber() 한 메서드로 합치기
	// private void inputCars() {
	// 	cars = new ArrayList<>();
	// 	MessageResponse.of(Message.ENTER_CARS_NAME.getMessage());
	// 	String inputStr = Console.readLine();
	//
	// 	try {
	// 		checkNull(inputStr);
	// 		checkCarsNameLength(inputStr.split(","));
	//
	// 	} catch (IllegalArgumentException e) {
	// 		ErrorResponse.of(e.getMessage());
	// 		inputCars();
	// 	}
	// }
	//
	// private void inputRepeatNumber() {
	// 	MessageResponse.of(Message.ASK_REPEAT_NUM.getMessage());
	// 	String inputStr = Console.readLine();
	//
	// 	try {
	// 		checkNull(inputStr);
	// 		checkInputIsPositiveNumber(inputStr);
	//
	// 	} catch (IllegalArgumentException e) {
	// 		ErrorResponse.of(e.getMessage());
	// 		inputRepeatNumber();
	// 	}
	// }
	//
	// // 결과 알려주기
	// private void getResult() {
	// 	MessageResponse.of(Message.PRINT_RESULT.getMessage());
	// 	for (int i = 0; i < repeatNumber; i++) {
	// 		decideMoveOrStop();
	// 		checkSorting(i);
	// 		System.out.println();
	// 	}
	// }
	//
	// private void decideMoveOrStop() {
	// 	for (int i = 0; i < cars.size(); i++) {
	// 		compareRandomNum(i);
	// 	}
	// }
	//
	// private void compareRandomNum(int carIdx) {
	// 	if (Randoms.pickNumberInRange(0, 9) >= 4) {
	// 		cars.get(carIdx).addPosition();
	// 	}
	// 	printResult(carIdx);
	// }
	//
	// private void printResult(int carIdx) {
	// 	Car car = cars.get(carIdx);
	// 	System.out.print(car.getName() + " : ");
	// 	for (int i = 0; i < car.getPosition(); i++) {
	// 		System.out.print("-");
	// 	}
	// 	System.out.println();
	// }
	//
	// private void checkSorting(int idx) {
	// 	if (idx == repeatNumber - 1) {
	// 		Collections.sort(cars);
	// 	}
	// }
	//
	// // 최종 우승자 알려주기
	// private void getWinner() {
	// 	MessageResponse.of(Message.ENTER_WINNER.getMessage());
	// 	int idx = checkNumberOfWinner();
	// 	for (int i = 0; i < idx; i++) {
	// 		System.out.print(cars.get(i).getName());
	// 		checkAddComma(i,idx);
	// 	}
	// }
	//
	// private int checkNumberOfWinner() {
	// 	int winnerNum = 1;
	// 	Car maxPosCar = cars.get(0);
	// 	for (int i = 1; i < cars.size(); i++) {
	// 		if (cars.get(i).getPosition() != maxPosCar.getPosition()) {
	// 			break;
	// 		}
	// 		winnerNum++;
	// 	}
	//
	// 	return winnerNum;
	// }
	//
	// private void checkAddComma(int idx, int len) {
	// 	if (idx < len - 1) {
	// 		System.out.print(", ");
	// 	}
	// }
	//
	// //TODO: validation Class 로 빼기
	// private void checkCarsNameLength(String[] carsStr) {
	// 	for (String car : carsStr) {
	// 		if (car.length() > 5) {
	// 			throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_ERROR.getErrorMessage());
	// 		}
	// 		cars.add(new Car(car));
	// 	}
	// }
	//
	// //TODO: validation Class 로 빼기
	// private void checkNull(String inputStr) {
	// 	if (inputStr.length() == 0) {
	// 		throw new IllegalArgumentException(ErrorMessage.NULL_ERROR.getErrorMessage());
	// 	}
	// }
	//
	// //TODO: validation Class 로 빼기
	// private void checkInputIsPositiveNumber(String inputStr) {
	// 	for (char c : inputStr.toCharArray()) {
	// 		if (!Character.isDigit(c) || c - '0' < 0) {
	// 			throw new IllegalArgumentException(ErrorMessage.NOT_CORRECT_REPEAT_NUM_ERROR.getErrorMessage());
	// 		}
	// 	}
	// 	repeatNumber = Integer.parseInt(inputStr);
	// }
}
