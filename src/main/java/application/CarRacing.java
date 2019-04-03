package application;

import java.util.Scanner;

import domain.Car;

public class CarRacing {
	private static final String NAME_SEPARATOR = ",";
	Car[] cars;
	
	public void run() {
		initialize();
	}

	private void initialize() {
		String[] names = receiveInputNames().split(NAME_SEPARATOR);
		cars = new Car[names.length];
		for (int i = 0; i < names.length; i++) {
			cars[i] = new Car(names[i].trim());
		}
	}

	private String receiveInputNames() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표("+NAME_SEPARATOR+") 기준으로 구분)");
		String inputNames = scanner.nextLine();
		scanner.close();
		return inputNames;
	}
}
