package application;

import java.util.Scanner;

import domain.Car;

public class CarRacing {
	private static final String NAME_SEPARATOR = ",";
	private int times;
	private Car[] cars;
	private Scanner scanner;

	public void run() {
		initialize();
	}

	private void initialize() {
		Scanner scanner = new Scanner(System.in);
		String[] names = receiveInputNames().split(NAME_SEPARATOR);
		this.times = recieveInputTimes();
		setCars(names);
		scanner.close();
	}

	private String receiveInputNames() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(" + NAME_SEPARATOR + ") 기준으로 구분)");
		return scanner.nextLine();
	}

	private int recieveInputTimes() {
		System.out.println("시도할 횟수는 몇회인가요?");
		return scanner.nextInt();
	}

	private void setCars(String[] names) {
		cars = new Car[names.length];
		for (int i = 0; i < names.length; i++) {
			cars[i] = new Car(names[i].trim());
		}
	}
}
