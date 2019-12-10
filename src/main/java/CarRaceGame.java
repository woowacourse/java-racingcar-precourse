import domain.Car;
import sources.CarRaceSource;
import utils.UtilityMethods;

import java.util.ArrayList;
import java.util.Scanner;

public class CarRaceGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		String inputString = "";
		ArrayList<String> winners = new ArrayList<String>();

		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
		inputString = sc.nextLine();
		System.out.println("시도할 회수는 몇회인가요?");
		count = sc.nextInt();
		Car[] cars = UtilityMethods.sliceString(inputString);
		CarRaceSource.playGameByNumber(count, cars);
		winners = CarRaceSource.judgeWinner(cars);
		CarRaceSource.printWinner(winners);
	}
}