package domain;

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
			
			if(!isEffectiveFormat(names)) continue;
			//names로 Car 객체들을 생성코드 추가.
			
			break;
		}
		System.out.println("시도할 회수는 몇회인가요?");
		round = sc.nextInt();
		
		gameStart(racingCars,1,round);
		//게임 종료후 결과 출력하는 코드 추가
		
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
	
	private static void calMax(int position) {
		if (position > maxPosition) {
			maxPosition = position;
		}
	}
}
