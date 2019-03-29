package play;

import java.util.Scanner;

public class PlayRacingGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. 사용자로부터 car 이름 받기
		String carNames[] = receiveCarNamesFromUser();
		// 2. car 객체 생성
		// 3. 게임 진행

	}
	
	private static String[] receiveCarNamesFromUser() {
		Scanner sc = new Scanner(System.in);
		String inputNames = sc.next();
		sc.close();
		
		return inputNames.split(",");
	}

}
