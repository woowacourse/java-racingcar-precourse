package domain;

import java.util.Scanner;

public class Game {

	private int attemptCount;

	Scanner scanner = new Scanner(System.in);

	public void runPrompt() {
		inputCarName();
		numOfAttempts();
		System.out.println("실행 결과\n");
		for (int i = 1; i <= attemptCount; i++) {
			System.out.println(i + " 라운드");
			playGame();
			System.out.println();
		}
		printWinner();
		scanner.close();
	}

	private void inputCarName() {
		// TODO
		
	}

	private void numOfAttempts() {
		// TODO
		
	}

	private void playGame() {
		// TODO
		
	}

	private void printWinner() {
		// TODO
		
	}
}
