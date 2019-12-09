import java.util.Scanner;

import domain.Car;

public class UtilityTest {
	public static void main(String[] args) {
		//슬라이싱 동작 테스트
		Scanner sc = new Scanner(System.in);

		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
		String testString = sc.nextLine();
		Car[] testCars = UtilityMethods.sliceString(testString);
		for (int i = 0; i < testCars.length; i++) {
			System.out.println(testCars[i].getName() + " : " + testCars[i].getPosition());
		}

		UtilityMethods.goForwardRandomly(testCars);
		for (int i = 0; i < testCars.length; i++) {
			System.out.println(testCars[i].getName() + " : " + testCars[i].getPosition());
		}

	}
}

