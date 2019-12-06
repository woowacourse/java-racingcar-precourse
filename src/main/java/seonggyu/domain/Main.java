package seonggyu.domain;

import seonggyu.cars.Cars;
import seonggyu.input.Input;
import java.util.List;

public class Main {
	public static void main(String args[]) {
		List<String> carNames = Input.enterCarNames();
		Cars cars = new Cars(carNames);
		cars.printNames();
		
		int temp = Input.enterRounds();
		
		for(int i = 0; i < temp; i++) {
			System.out.println(i);
			cars.decidePositions();
			cars.printNamesAndPositions();
			System.out.println();
		}
	}
}
