package domain;

import java.util.Scanner;

public class GameMain {

	static String nameArray[];
	static Car cars[];
	static int position[];

	// 쉼표 기준으로 이름 구분하는 메소드
	static void nameDistinguish(String names) {
		nameArray = names.split(",");
	}

	// 이름이 5자 이하인지 확인하는 메소드
	static boolean isNameLessThan5() {
		for (int i = 0; i < nameArray.length; ++i) {
			if (nameArray[i].length() > 5) {
				System.out.println("자동차 이름은 5자 이하만 가능합니다.");
				System.out.println("경주할 자동차 이름을 입력하세요. 이름은 쉼표(,) 기준으로 구분");
				return false;
			}
		}
		return true;
	}

	// 자동차 객체 생성하는 메소드
	static void makeCars() {
		cars = new Car[nameArray.length];
		for (int i = 0; i < nameArray.length; ++i) {
			cars[i] = new Car(nameArray[i]);
		}
	}

	// 0~9 까지 난수 생성 메소드
	static int randomNum() {
		return (int) (Math.random() * 10);
	}

	// 4 이상이면 전진시켜주는 메소드
	static void isMoreThan4(int randomNum, int index) {
		if (randomNum >= 4) {
			cars[index].addPosition();
		}
	}

	// 실행결과 출력하는 메소드
	static void printState(int index) {
		System.out.print(nameArray[index] + " : ");
		for (int i = 0; i < cars[index].getPosition(); ++i) {
			System.out.print("-");
		}
		System.out.println();
	}

	// 시도 횟수만큼 반복하는 메소드
	static void repeat(int moveNum) {
		while (moveNum != 0) {
			moveNum--;
			for (int i = 0; i < nameArray.length; ++i) {
				isMoreThan4(randomNum(), i); // random 값이 4이상인지 확인
				printState(i); // 상황 출력
			}
			System.out.println();
		}
	}

	// 가장 큰 position값 구하는 메소드
	static int maxValue() {
		position = new int[nameArray.length];
		int maxPosition = 0;
		for (int i = 0; i < nameArray.length; ++i) {
			position[i] = cars[i].getPosition();
			if (maxPosition < position[i]) {
				maxPosition = position[i];
			}
		}
		return maxPosition;
	}

	// 이름과 이름사이에 쉼표를 넣어 결과를 출력하는 메소드
	static void printResult(int index, boolean rest) {
		if (rest)
			System.out.print(", ");
		System.out.print(nameArray[index]);
	}

	// 결과 출력 메소드
	static void result(int maxPosition) {
		boolean rest = false;
		for (int i = 0; i < nameArray.length; ++i) {
			if (position[i] == maxPosition) {
				printResult(i, rest);
				rest = true;
			}
		}
		System.out.println(" 가 최종 우승했습니다.");
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

		do {
			String names = in.next(); // 자동차 이름 입력
			nameDistinguish(names); // 쉼표 기준으로 이름 구분
		} while (!isNameLessThan5());
		makeCars(); // 자동차 객체 생성

		System.out.println("시도할 횟수는 몇회인가요?");
		int moveNum = in.nextInt(); // 시행 횟수 입력
		System.out.println("실행 결과");
		repeat(moveNum); // n회 반복

		int maxPosition = maxValue();
		result(maxPosition);
	}

}
