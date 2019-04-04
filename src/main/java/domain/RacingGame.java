package domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
	private Car[] cars;
	private String[] arrCarNames;
	private List<Car> winner;
	
	public RacingGame() {
		UserInput user = new UserInput();
		int numberOfAttemp;
		
		arrCarNames = user.setCarNames();
		setCarObject();
		printCarNames();
		
		numberOfAttemp = user.setNumberOfAttep();
		System.out.println("\n실행결과");
		for (int i = 0; i < numberOfAttemp; i++) {
			moveCar();
		}
		
		getWinner();
		printWinner();
	}
	
	private void setCarObject () {
		cars = new Car[arrCarNames.length];
		
		for (int i = 0; i < cars.length; i++) {
			cars[i] = new Car(arrCarNames[i]);
		}
	}
	
	private void printCarNames() {
		for (int i = 0; i < cars.length; i++) {
			System.out.print(cars[i].getName());
			
			if (i != cars.length-1) {
				System.out.print(",");
			}
		}
		System.out.println();
	}
	
	private void moveCar() {
		for (Car car : cars) {
			car.randomMovingDistance();
			car.increasePosition();
			car.printMovingDistance();
		}
		System.out.println();
	}
	
	private void getWinner() {
		int maxNum = cars[0].getPosition();
		
		for (int i = 1; i < cars.length; i++) {
			maxNum = Math.max(maxNum, cars[i].getPosition());
		}
		
		winner = new ArrayList<>();
		for (Car car : cars) {
			if (car.getPosition() == maxNum) {
				winner.add(car);
			}
		}
	}
	
	private void printWinner() {
		for (int i = 0; i < winner.size(); i++) {
			System.out.print(winner.get(i).getName());
			
			if (i != winner.size()-1) {
				System.out.print(",");
			}
		}
		System.out.print("가 최종 우승했습니다.");
	}
	
	public static void main(String[] args) {
		new RacingGame();
	}
}
