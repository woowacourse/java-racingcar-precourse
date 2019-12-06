package seonggyu.domain;

import seonggyu.cars.Car;
import seonggyu.input.Input;
import java.util.List;

public class Main {
	public static void main(String args[]) {
		List<String> carsList = Input.enterCarNames();
		
		for (int i = 0; i < carsList.size(); i++) {
			System.out.println(i + ": " + carsList.get(i));
		}
		
		int temp = Input.enterRounds();
		System.out.println(temp);
		
		Car mycar = new Car("mycar");
		Car mycar2 = new Car("mycar2");
		while(true) {
			Input.enterCarNames();
			mycar.decidePosition();
			mycar2.decidePosition();
			mycar.printNameAndPosition();
			mycar2.printNameAndPosition();
		}
	}
}
