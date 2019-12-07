import java.util.Scanner;
import domain.Car;

public class UtilityTest {
	public static void main(String[] args) {
		//슬라이싱 동작 테스트
		Scanner sc = new Scanner(System.in);

		String testString = sc.nextLine();
		Car[] testCars = UtilityMethods.sliceString(testString);
		for (int i = 0; i < testCars.length; i++) {
			//testCars[i].goForward();
			System.out.println(testCars[i].getName() + " : " + testCars[i].getPosition());
		}

		UtilityMethods.goForwardRandomly(testCars);
		for (int i = 0; i < testCars.length; i++) {
			//testCars[i].goForward();
			System.out.println(testCars[i].getName() + " : " + testCars[i].getPosition());
		}
	}
}

