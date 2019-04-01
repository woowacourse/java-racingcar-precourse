package domain;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int maxPosition;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int round = 0;
		String names[] = null;
		Car[] racingCars = null;
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.print("경주할 자동차 이름을 입력하세요.");
			System.out.println("(이름은 쉼표(,)를 기준으로 구분)");
			names = sc.next().split(",");
			
			if(isEffectiveFormat(names)) { 
				break;
			}
		}
		
		racingCars = new Car[names.length];
		for (int i = 0; i < racingCars.length; i++) {
			racingCars[i] = new Car(names[i]); 
		}
		
		System.out.println("시도할 회수는 몇회인가요?");
		round = sc.nextInt();
		
		gameStart(racingCars,1,round);
		gameFisish(racingCars);
		
		sc.close();
	}

	private static void gameStart(Car[] cars,int now, int total) {
		for (int i = 0; i < cars.length; i++) {
			cars[i].run();
			cars[i].printState();
			calMax(cars[i].getPosition());
		}
		
		if (now < total) {
			gameStart(cars, now+1, total);
		}
	}

	private static boolean isEffectiveFormat(String[] names) {
		boolean result = true;
		
		for (int i = 0; i < names.length; i++) {
			if (names[i].length()>5) {
				System.out.println("5자가 넘어가는 이름이 있습니다.");
				result = false;
				break;
			}
		}
		return result;
	}
	
	private static void gameFisish(Car[] cars) {
		ArrayList<Car> winner = getWinner(cars);
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < winner.size(); i++) {
			//자동차 이름 하나씩 출력하는 기능 넣어야해.
			//이를 위해선. 자동차 객체에서 이름 가져오는 메소드 추가
			if (i != winner.size()-1) {
				sb.append(", ");
			}
		}
		sb.append("가 최종우승했습니다.\n");
		System.out.println(sb.toString());
	}
	
	private static ArrayList<Car> getWinner(Car[] cars){
		ArrayList<Car> result = new ArrayList<Car>();
		
		for (int i = 0; i < cars.length; i++) {
			if (cars[i].getPosition() == maxPosition) {
				result.add(cars[i]);
			}
		}
		
		return result;
	}
	
	private static void calMax(int position) {
		if (position > maxPosition) {
			maxPosition = position;
		}
	}
}
