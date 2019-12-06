package seonggyu.domain;

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
		while(true) {
			Input.enterCarNames();
			mycar.decidePosition();
			System.out.println("curposition: " + mycar.getPosition());
		}
	}
}
