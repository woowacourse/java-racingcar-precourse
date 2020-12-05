package outpututils;

import racingcar.Car;

import java.util.ArrayList;

public class Print {
	private Print(){

	}

	public static void PrintResult(ArrayList<Car> participatedCar){
		for(Car player : participatedCar){
			PrintTurnResult(player);
		}
		System.out.println();
	}

	private static void PrintTurnResult(Car player){
		System.out.print(player.GetName() + " : ");
		PrintPlayerPosition(player);
	}

	private static void PrintPlayerPosition(Car player){
		for(int count = 0; count < player.GetPosition(); count++){
			System.out.print("-");
		}
		System.out.println();
	}
}
