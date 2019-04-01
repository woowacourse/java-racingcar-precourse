package domain;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int round;
		String names[];
		Car[] racingCars;
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
		
		//round만큼 게임 실행 코드 추가
		//게임 종료후 결과 출력하는 코드 추가
		
		sc.close();
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
	
}
