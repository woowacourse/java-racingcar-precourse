package domain;
import java.util.Scanner;

public class playGame { 	
	private String carInputString;
	private int roundNum;
	private String[] car;
	private Car[] race;
	
	public void play() {
		getCarName();
		makeRace();
	}
	
	public void getCarName() {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("경주에 참가할 자동차 이름을 입력하세요 각 차량은 쉼표(,)로 구분합니다.");
			this.carInputString = sc.nextLine();
		} while(nameVaild(carInputString));
		
		System.out.println("경기 횟수를 입력하세요");
		this.roundNum = sc.nextInt();
	}
	
	public boolean nameVaild(String inputString) {
		this.car = inputString.split(",");
		
		for (int i = 0; i < car.length; i++) {
			if(car[i].length() > 5) {
				System.out.println("입력한 자동차 이름 중에 5자리 초과가 있습니다.");
				return true;
			}
		}
		return false;
	}
		
	public void makeRace() {
		race = new Car[car.length];
		for (int i = 0; i < car.length; i++) {
			race[i] = new Car(car[i]);
		}
	}
	
	public void setGameNum() {
		
	}
	
	public void gameResult() {
		
	}
	public void gameWinner() {
		
	}
	
}
