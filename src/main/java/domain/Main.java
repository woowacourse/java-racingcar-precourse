package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static final String CAR_NAME_QUESTION = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	static final String REPETITION_QUESTION = "시도할 회수는 몇회인가요?";
	static final String SHOW_RESULT = "실행 결과";
	static final String FINAL_RESULT = "가 최종 우승했습니다.";

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		System.out.println(CAR_NAME_QUESTION);

		String nameOfCars = in.readLine();

		String[] carNameArr = nameOfCars.split(",");
		int numOfCars = carNameArr.length;

		// 자동차 이름이 5자 이상
		if (!checkCarNameLength(carNameArr)) {
			System.out.println("자동차 이름이 5자 초과입니다. 종료합니다.");
			return;
		}

		Car[] carArr = new Car[numOfCars];

		for (int i = 0; i < numOfCars; i++) {
			carArr[i] = new Car(carNameArr[i]);
		}

		System.out.println(REPETITION_QUESTION);

		int repetitionCount = Integer.parseInt(in.readLine());

		System.out.println(SHOW_RESULT);
		while (repetitionCount-- > 0) {
			for (int i = 0; i < numOfCars; i++) {
				carArr[i].moveOrStop();
			}
			printResult(carArr);
		}
		printWinner(carArr);
	}

	private static void printWinner(Car[] carArr) {
		StringBuffer sb = new StringBuffer();
		int maxDistance = -1;
		for (int i = 0; i < carArr.length; i++) {
			maxDistance = Math.max(maxDistance, carArr[i].getPosition());
		}
		for (int i = 0; i < carArr.length; i++) {
			if (carArr[i].getPosition() == maxDistance) {
				sb.append(carArr[i].getName() + ", ");
			}
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.toString() + FINAL_RESULT);
	}

	private static void printResult(Car[] carArr) {
		for (int i = 0; i < carArr.length; i++) {
			String currentCarName = carArr[i].getName();
			int currentCarPossition = carArr[i].getPosition();
			System.out.println(currentCarName + ":" + movedDistance(currentCarPossition));
		}
		System.out.println();
	}

	private static String movedDistance(int movedCount) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < movedCount; i++) {
			sb.append("-");
		}
		return sb.toString();
	}

	private static boolean checkCarNameLength(String[] carNameArr) {
		for (int i = 0; i < carNameArr.length; i++) {
			if (carNameArr[i].length() > 5) {
				return false;
			}
		}
		return true;
	}

}
