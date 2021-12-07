package racingcar;

import java.util.ArrayList;

public class GamePrinter {

	public static void stagePrint(Car[] cars){

		for(Car car : cars){
			System.out.print(car.getName() + " : ");

			for(int i = 0; i < car.getPosition(); i++){
				System.out.print("-");
			}

			System.out.print("\n");
		}

		System.out.print("\n");
	}

	public static void goToStagePrint(){
		System.out.print("\n실행 결과\n");
	}

	public static void getNamePrint(){

		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
	}

	public static void getNumberPrint(){
		System.out.println("시도할 회수는 몇회인가요?");
	}

	public static void printChampion(String[] champions){



		System.out.print("최종우승자 : ");
		System.out.print(champions[0]);

		for(int i = 1; i < champions.length; i++){
			System.out.print(", " + champions[i]);
		}

		System.out.print("\n");
	}
}
