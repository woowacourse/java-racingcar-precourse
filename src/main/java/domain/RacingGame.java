package domain;

import java.util.Scanner;

public class RacingGame {
	public Scanner sc;
	public Car[] cars;
	public int rounds;

	public RacingGame() {
		sc = new Scanner(System.in);
	}

	public void start() {
		ready();
		print("\n실행 결과");
		while (rounds != 0) {
			play();
			print("");
			rounds--;
		}
		getResult();
	}

	public void print(String msg) {
		System.out.println(msg);
	}

	public void ready() {
		String[] nameList = inputNames();
		cars = makeCars(nameList);
		rounds = inputRounds();
		if (sc != null) {
			sc.close();
		}
	}

	public void play() {
		for (int j = 0; j < cars.length; j++) {
			int energy = getRandomNumber();
			cars[j].tryToMove(energy);
			cars[j].printPosition();
		}
	}

	public void getResult() {
		String winners = getWinners();
		print(winners + "(이)가 최종 우승했습니다.");
	}

	public String[] inputNames() {
		print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분)\n 예시) pobi, crong, honux");
		String names = sc.nextLine();
		String[] nameList = names.split(",", -1);

		while (!validate(nameList)) {
			print("이름 입력형식이 잘못되었습니다. 다시 입력해주세요.\n 예시) pobi, crong, honux");
			names = sc.nextLine();
			nameList = names.split(",", -1);
		}
		return nameList;
	}

	public boolean validate(String[] nameList) {
		for (int i = 0; i < nameList.length; i++) {
			String name = nameList[i].trim();
			if ((name.equals("")) || (name.length() > 5)) {
				return false;
			}
		}
		return true;
	}

	public Car[] makeCars(String[] nameList) {
		Car[] cars = new Car[nameList.length];

		for (int i = 0; i < nameList.length; i++) {
			cars[i] = new Car(nameList[i].trim());
		}
		return cars;
	}

	public int inputRounds() {
		print("\n시도할 회수는 몇 회인가요?");
		String rounds = sc.nextLine();

		while (!isDigit(rounds)) {
			print("라운드 입력 형식이 잘못되었습니다. 숫자를 다시 입력해주세요.");
			rounds = sc.nextLine();
		}
		return Integer.parseInt(rounds);
	}

	public boolean isDigit(String rounds) {
		try {
			Integer.parseInt(rounds);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public int getRandomNumber() {
		return (int) (Math.random() * 10);
	}

	public String getWinners() {
		int maxPosition = 0;
		String winners = "";

		for (Car car : cars) {
			int position = car.getResult();
			if (position > maxPosition) {
				maxPosition = position;
				winners = car.getName();
				continue;
			}
			if (position == maxPosition) {
				winners += ", " + car.getName();
			}
		}
		return winners;
	}
}
