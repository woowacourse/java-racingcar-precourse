package racingcar;

import java.util.Scanner;

public class Application {
	private static final String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String ERROR_NAME_MESSAGE = "[ERROR] 5자초과에 이름은 가질수없으므로 삭제됩니다";
	
	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		// TODO 援ы쁽 吏꾪뻾

		System.out.println(INPUT_NAME_MESSAGE);
		String input = scanner.nextLine();
		String[] inputCars = input.split(",");
		inputCars = checkInput(inputCars);
		
		
		Car[] cars = new Car[inputCars.length];
		cars = createCars(cars, inputCars);
		
		for (int i = 0; i < cars.length; i++) {
			cars[i].statusPrint();
		}
		
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
		System.out.println("ERROR_NAME_MESSAGE");
		return false;
	}
	
	public static Car[] createCars(Car[] cars, String[] inputCars)
	{
		for(int carCount = 0; carCount<cars.length;carCount++)
		{
			Car car = new Car(inputCars[carCount]);
			cars[carCount] = car;
		}
		return cars;
	}
}
