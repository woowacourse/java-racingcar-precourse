/*
 * RacingGame
 * 
 * version 1.0
 * 
 * 2019. 4. 2
 * 
 * Created by Wongeun Song
 */

package domain;

import java.util.Scanner;
import java.util.Vector;

public class RacingGame {
	private Scanner scanner = new Scanner(System.in);
	private Vector<Car> Cars = new Vector<Car>();
	private int round = 0;

	public void play() {
		String carNameList;
		String[] carNameArray;
		String winnerCarNameList;
		
		do {
			carNameList = this.inputCarNameList();
			carNameArray = this.parseCarNameList(carNameList);
		} while (!this.isCollectCarNameLength(carNameArray));
		this.inputRound();
		this.makeCars(carNameArray);
		this.runRounds();
		winnerCarNameList = this.findWinner();
		this.printWinner(winnerCarNameList);
	}
	
	private String inputCarNameList() {
		System.out.println(Message.REQUEST_CAR_NAME_LIST);
		return scanner.nextLine();
	}

	private String[] parseCarNameList(String carNameList) {
		return carNameList.split(",");
	}
	
	private boolean isCollectCarNameLength(String[] carNames) {
		for (int i = 0; i < carNames.length; i++) {
			if (carNames[i].length() > 5) {
				System.out.println(Message.NAME_LENGTH_ERROR);
				return false;
			}
		}
		return true;
	}

	private void inputRound() {
		System.out.println(Message.REQUEST_NUMBER_OF_ROUND);
		while (true) {
			this.round = this.parseRound(scanner.next());
			if (this.round != -1) {
				break;
			}
			System.out.println(Message.INVAILD_NUMBER_ERROR);
		}
	}
	
	/**
	 * String 형태의 round가 유효한 정수로 변환될 수 있는지 판단하는 메소드
	 * @param round
	 * @return 1이상의 유효한 정수값이면 round를 파싱한 정수형 값을 출력, 유효하지 않은 경우 -1을 출력
	 */
	private int parseRound(String round) {
		try {
			int intRound = Integer.parseInt(round);
			if (1 <= intRound && intRound <= 10000) {
				return intRound; 
			}
			return -1;
		} catch (NumberFormatException error) {
			return -1;
		}
	}

	private void makeCars(String[] carNameArray) {
		for (int i = 0; i < carNameArray.length; i++) {
			Cars.add(new Car(carNameArray[i]));
		}
	}

	private void runRounds() {
		System.out.println(Message.RUN_RESULT);
		for (int i = 0; i < this.round; i++) {
			this.moveCars();
			System.out.println("\n");
		}
	}

	private void moveCars() {
		Car car;

		for (int i = 0; i < Cars.size(); i++) {
			car = Cars.elementAt(i);
			car.move();
			car.printPosition();
		}
	}

	private String findWinner() {
		String winnerCarNameList = "";
		int farthestPosition = -1;

		for (int i = 0; i < Cars.size(); i++) {
			Car car = Cars.elementAt(i);
			if (farthestPosition < car.getPosition()) {
				winnerCarNameList = car.getName();
				farthestPosition = car.getPosition();
				continue;
			}
			if (farthestPosition == car.getPosition()) {
				winnerCarNameList += ", " + car.getName();
			}
		}
		return winnerCarNameList;
	}

	private void printWinner(String winnerCarNameList) {
		System.out.println(winnerCarNameList + Message.END_OF_WINNER_MESSAGE);
	}
}
