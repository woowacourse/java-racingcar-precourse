package domain;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	private ArrayList<Car> myCar;
	private Printer myPrinter;
	private Scanner in;
	private String[] carName;

	public Game() {
		myCar = new ArrayList<Car>();
		myPrinter = new Printer();
		in = new Scanner(System.in);
	}

	private void run() {
		getCarName();
	}

	private void getCarName() {
		String inputName;

		try {
			myPrinter.printInputCarName();
			inputName = in.next();
			checkNameValidation(inputName);
		} catch (InputException e) {
			getCarName();
		}
	}

	private void checkNameValidation(String name) {
		isContainComma(name);
		isStartComma(name);
		isEndComma(name);
		parseName(name);
		isEmptyCarName();
		checkCarNameLength();
	}

	private void isContainComma(String name) {
		if (!name.contains(Constant.COMMA)) {
			myPrinter.printContainComma();
			throw new InputException();
		}
	}

	private void isStartComma(String name) {
		if (name.startsWith(Constant.COMMA)) {
			myPrinter.printEmptyCarName();
			throw new InputException();
		}
	}

	private void isEndComma(String name) {
		if (name.endsWith(Constant.COMMA)) {
			myPrinter.printEmptyCarName();
			throw new InputException();
		}
	}

	private void parseName(String name) {
		carName = name.split(Constant.COMMA);
	}

	private void isEmptyCarName() {
		for (String s : carName) {
			if (s.equals("")) {
				myPrinter.printEmptyCarName();
				throw new InputException();
			}
		}
	}

	private void checkCarNameLength() {
		for (String s : carName) {
			if (s.length() > 5) {
				myPrinter.printCarNameLength();
				throw new InputException();
			}
		}
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.run();
	}
}
