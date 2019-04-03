package application;

import java.util.Scanner;

import domain.Car;

public class CarRacing {

	Car[] cars;
	
	public void run() {
		initialize();
	}

	private void initialize() {
		String names = receiveInputNames();
	}

	private String receiveInputNames() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)");
		return scanner.nextLine();
	}
}
