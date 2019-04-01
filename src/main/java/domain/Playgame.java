package domain;

import java.util.ArrayList;
import java.util.Scanner;

public class Playgame {

	public static void main(String[] args) {

		ArrayList<Car> carlist = new ArrayList<>();
		
		int winnerPoint = 0;
		int gameRound = initSetup(carlist);
		
		for (int i = 0; i < gameRound; i++) {

			System.out.println("실행결과");
			
			for (int j = 0; j < carlist.size(); j++) {
				carlist.get(j).acceleratorAndbreak();
				carlist.get(j).playRacing();
				winnerPoint = Math.max(winnerPoint, carlist.get(j).getPosition());
			}

			System.out.println();
		}

		checkWinner(carlist, winnerPoint);

	}

	private static void checkWinner(ArrayList<Car> carlist, int winnerPoint) {

		int cnt = 0;
		for (int i = 0; i < carlist.size(); i++) {

			if (winnerPoint == carlist.get(i).getPosition()) {
				if (cnt > 0) {
					System.out.print(",");
				}
				System.out.print(carlist.get(i).getName());
				cnt++;
			}
		}

		System.out.println("가 최종 우승했습니다");

	}

	private static int initSetup(ArrayList<Car> carlist) {

		Scanner scan = new Scanner(System.in);
		
		String input = null;
		int Round = 0;

		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분)");
		input = scan.nextLine();

		createCar(input, carlist);

		System.out.println("시도할 회수는 몇회인가요?");
		Round = scan.nextInt();
		System.out.println();
		
		return Round;

	}

	private static void createCar(String input, ArrayList<Car> carlist) {

		String[] carNameSplite = input.split(",");

		for (int i = 0; i < carNameSplite.length; i++) {
			carlist.add(new Car(carNameSplite[i]));
		}

	}

}
