package domain;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;


/**
 * 자동차 경주 게임을 수행하는 클래스.
 * @author giantim
 */
public class Game {
	private ArrayList<Car> myCar;
	private Printer myPrinter;
	private Scanner in;
	private String[] carName;
	private int gameCount;
	private Random random;
	/*
	 * 게임이 계속 진행될지 판단하는 변수 
	 */
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
	
	/**
	 * 사용자에게 자동차 이름, 게임 시도 횟수 등을 입력받고
	 * 자동차 객체를 초기화한다.
	 */
	private void getGameInformation() {
		getCarName();
		getGameCount();
		initializeCar();
	}
	
	/**
	 * 자동차 이름의 입력받고 유효성을 검사한다.
	 */
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
	
	/**
	 * 입력받은 자동차 이름의 유효성을 검사한다, 검사 항목으로는
	 * 쉼표가 포함되어 있는지, 공백 이름을 입력했는지,
	 * 이름이 5글자 이하인지 등을 검사한다.
	 * @param name 입력받은 자동차 이름 문자열. 파싱되어있지 않다.
	 */
	private void checkNameValidation(String name) {
		isContainComma(name);
		isStartComma(name);
		isEndComma(name);
		parseName(name);
		isEmptyCarName();
		checkCarNameLength();
	}
	
	/**
	 * 파싱되지 않은 사용자 입력 문자열에 ,가 포함되어있는지 검사한다.
	 * @param name 입력받은 자동차 이름 문자열. 파싱되어있지 않다.
	 */
	private void isContainComma(String name) {
		if (!name.contains(Constant.COMMA)) {
			myPrinter.printContainComma();
			throw new InputException();
		}
	}
	
	/**
	 * ,로 시작하는 문자열 입력시 빈 이름이 포함되므로 예외이다.
	 * @param name 입력받은 자동차 이름 문자열. 파싱되어있지 않다.
	 */
	private void isStartComma(String name) {
		if (name.startsWith(Constant.COMMA)) {
			myPrinter.printEmptyCarName();
			throw new InputException();
		}
	}
	
	/**
	 * ,로 끝나는 문자열 입력시 빈 이름이 포함되므로 예외이다.
	 * @param name 입력받은 자동차 이름 문자열. 파싱되어있지 않다.
	 */
	private void isEndComma(String name) {
		if (name.endsWith(Constant.COMMA)) {
			myPrinter.printEmptyCarName();
			throw new InputException();
		}
	}

	private void parseName(String name) {
		carName = name.split(Constant.COMMA);
	}
	
	/**
	 * 빈 문자열이 이름인 상황은 예외이다.
	 */
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
	
	/**
	 * 시도 횟수의 유효성을 검사한다. 유효성 검사 항목은
	 * 입력이 0~9의 숫자로만 이루어져있는지 검사한다.
	 * @param number 사용자가 숫자로 입력한 문자열
	 */
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
	
	/**
	 * 자동차들 중에서 게임 시도 횟수와 위치가 같은 자동차가 있는지 찾는다.
	 * 만약 위치가 같은 자동차가 있다면 isPrize 변수를 true로 변경한다.
	 * 그리고 게임 실행의 반복문을 제어하는 isEnd를 true로 변경한다.
	 */
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
