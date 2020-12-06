package outpututils;

import racingcar.Car;

import java.util.ArrayList;

public class Print {

	public static void PrintResult(ArrayList<Car> participatedCar) {
		for (Car player : participatedCar) {
			PrintTurnResult(player);
		}
		System.out.println();
	}

	public static void PrintWinner(ArrayList<String> winners) {
		System.out.print("최종 우승자: ");
		System.out.println(String.join(", ",winners));
	}

	private static void PrintTurnResult(Car player) {
		System.out.print(player.GetName() + " : ");
		PrintPlayerPosition(player);
	}

	private static void PrintPlayerPosition(Car player) {
		for (int count = 0; count < player.GetPosition(); count++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
