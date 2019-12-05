package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
	private List<Car> carList;
	private Scanner scan;
	private int tryGame;

	public Game() {
		carList = new ArrayList<Car>();
		scan = new Scanner(System.in);

		requestCarName();
	}

	public void requestCarName() {
		String carName;
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
		carName = scan.nextLine();

	}
}
