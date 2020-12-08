package racingcar;

import java.util.Scanner;

public class Application {
	private static final String INPUT_NAME_MESSAGE = "������ �ڵ��� �̸��� �Է��ϼ���.(�̸��� ��ǥ(,) �������� ����)";
	private static final String ERROR_NAME_MESSAGE = "[ERROR] 5���ʰ��� �̸��� �����������Ƿ� �����˴ϴ�";
	private static final String INPUT_COUNT_MESSAGE = "�õ��� ȸ���� ��ȸ�ΰ���?";
	private static final String ERROR_INPUT_COUNT_MESSAGE = "[ERROR] �õ� Ƚ���� ���ڿ��� �Ѵ�.";
	private static final String GAME_START_MESSAGE = "\n���� ���.";
	
	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		// TODO 구현 진행

		System.out.println(INPUT_NAME_MESSAGE);
		String input = scanner.nextLine();
		String[] inputCars = input.split(",");
		inputCars = checkInput(inputCars);

		Car[] cars = new Car[inputCars.length];
		cars = createCars(cars, inputCars);

		int count = checkCount(scanner);
		
		gameStart(cars, count);
		
	}

	public static String[] checkInput(String[] inputCars) {
		int carCount = 0;
		String[] beforeInputCars = new String[inputCars.length];

		for (int number = 0; number < inputCars.length; number++) {
			if (checkLength(inputCars[number])) {
				beforeInputCars[carCount] = inputCars[number];
				carCount++;
			}
		}

		String[] affterInputCars = new String[carCount];
		for (int beforeNumber = 0; beforeNumber < carCount; beforeNumber++) {
			affterInputCars[beforeNumber] = beforeInputCars[beforeNumber];
		}

		return affterInputCars;
	}

	public static Boolean checkLength(String inputCar) {
		if (inputCar.length() <= 5) {
			return true;
		}
		System.out.println(ERROR_NAME_MESSAGE);
		return false;
	}

	public static Car[] createCars(Car[] cars, String[] inputCars) {
		for (int carCount = 0; carCount < cars.length; carCount++) {
			Car car = new Car(inputCars[carCount]);
			cars[carCount] = car;
		}
		return cars;
	}

	public static int checkCount(Scanner scanner) {
		int count = 0;
		boolean checkNumber = false;
		while (!checkNumber) {
			try {
				System.out.println(INPUT_COUNT_MESSAGE);
				checkNumber = true;
				count = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println(ERROR_INPUT_COUNT_MESSAGE);
				checkNumber = false;
			}
		}
		return count;
	}

	public static void gameStart(Car[] cars, int count) {
		System.out.println(GAME_START_MESSAGE);
		for (int move = 0; move < count; move++) {
			moveCar(cars);
			System.out.println();
		}
		
		
	}

	public static void moveCar(Car[] cars) {
		for (int carsCount = 0; carsCount < cars.length; carsCount++) {
			cars[carsCount].move();
			cars[carsCount].statusPrint();
		}
	}
}
