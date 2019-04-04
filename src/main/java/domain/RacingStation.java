/*
 * RacingStation.java		2019/04/04
 * 
 * 이 프로그램은 누구든 수정 가능합니다.
 */
package domain;

import java.util.Scanner;

/**
 * 레이싱 게임을 제어하는 RacingStation 클래스이다.
 * 
 * @version 1.00 2019/04/04
 * @author DiceMono
 */
public class RacingStation {

	private Scanner scan = new Scanner(System.in);
	public Car[] carArray;

	public void getCarArray() {
		CarFactory factory = new CarFactory();
		carArray = factory.makeCarArray();
	}

	private int inputTryTimes() {
		System.out.println("시도할 회수는 몇회인가요?");
		int tryTimes = scan.nextInt();
		return tryTimes;
	}

	private void moveCars() {
		for (Car car : carArray) {
			car.tryMove();
		}
	}

	private void printSituation() {
		for (Car car : carArray) {
			car.printPosition();
		}
	}

	public void startRace() {
		int tryTimes = inputTryTimes();
		System.out.println("\n실행 결과");
		for (int count = 0; count < tryTimes; count++) {
			moveCars();
			printSituation();
			System.out.println();
		}
	}

	private int getFirstPlaceIndex() {
		int maxPosition = 0;
		int firstPlaceIndex = 0;

		for (int index = 0; index < carArray.length; index++) {
			Car car = carArray[index];
			if (car.getPosition() > maxPosition) {
				maxPosition = car.getPosition();
				firstPlaceIndex = index;
			}
		}
		return firstPlaceIndex;
	}

	public void printWinners() {
		int firstPlaceIndex = getFirstPlaceIndex();
		Car firstPlaceCar = carArray[firstPlaceIndex];
		int maxPosition = firstPlaceCar.getPosition();
		System.out.print(firstPlaceCar.getName());

		for (int index = firstPlaceIndex + 1; index < carArray.length; index++) {
			Car car = carArray[index];
			if (car.getPosition() == maxPosition) {
				System.out.print(", " + car.getName());
			}
		}
		System.out.println("가 최종 우승했습니다.");
	}

	/* 테스트 코드 */
	public static void main(String[] args) {
		RacingStation play = new RacingStation();
		play.getCarArray();
		play.startRace();
		play.printWinners();
	}
}
