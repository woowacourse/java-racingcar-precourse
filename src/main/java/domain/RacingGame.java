package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingGame {
	private Scanner sc;
	private List<Car> carList;

	public RacingGame() {
		sc = new Scanner(System.in);
		carList = new ArrayList<>();
	}

	public void startGame() {

	}

	private void inputCarNames() {
		String carNames = sc.nextLine();
	}	
}
