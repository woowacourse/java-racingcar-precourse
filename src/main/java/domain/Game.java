package domain;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Game {
	private ArrayList<Car> myCar;
	private Printer myPrinter;
	private Scanner in;
	private String[] carName;
	private int gameCount;
	private Random random;
	private boolean isEnd;

	public Game() {
		myCar = new ArrayList<Car>();
		myPrinter = new Printer();
		in = new Scanner(System.in);
		isEnd = false;
	}

	private void run() {
		getGameInformation();
		myPrinter.printPlayResult();
		do {
			moveCar();
			myPrinter.printCarInfomation(myCar);
			checkGameEnd();
		} while (!isEnd);
		myPrinter.printWinner(myCar);
	}

	private void getGameInformation() {
		getCarName();
		getGameCount();
		initializeCar();
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
			if (s.equals(Constant.EMPTY)) {
				myPrinter.printEmptyCarName();
				throw new InputException();
			}
		}
	}

	private void checkCarNameLength() {
		for (String s : carName) {
			if (s.length() > Constant.CAR_NAME_LENGTH) {
				myPrinter.printCarNameLength();
				throw new InputException();
			}
		}
	}

	private void getGameCount() {
		String inputCount;

		try {
			myPrinter.printGameCount();
			inputCount = in.next();
			checkCountValidation(inputCount);
		} catch (InputException e) {
			getGameCount();
		}
	}

	private void checkCountValidation(String number) {
		isNumber(number);
		convertNumber(number);
	}

	private void isNumber(String number) {
		for (char c : number.toCharArray()) {
			if (!(c >= Constant.ASCII_ZERO && c <= Constant.ASCII_NINE)) {
				myPrinter.printInputNumber();
				throw new InputException();
			}
		}
	}

	private void convertNumber(String number) {
		gameCount = Integer.parseInt(number);
	}

	private void initializeCar() {
		for (String s : carName) {
			myCar.add(new Car(s));
		}
	}

	private void moveCar() {
		random = new Random();

		for (Car c : myCar) {
			c.movePosition(random.nextInt(10));
		}
	}

	private void checkGameEnd() {
		for (Car c : myCar) {
			if (c.getPosition() == gameCount) {
				isEnd = true;
				c.setPrize();
			}
		}
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.run();
	}
}
