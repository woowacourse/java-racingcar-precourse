package domain;
import java.util.Scanner;

public class playGame { 	
	private String carInputString;
	private int roundNum;
	private String[] car;
	
	public void play() {
		getCarName();
	}
	
	public void getCarName() {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("���ֿ� ������ �ڵ��� �̸��� �Է��ϼ��� �� ������ ��ǥ(,)�� �����մϴ�.");
			this.carInputString = sc.nextLine();
		} while(nameVaild(carInputString));
		
		System.out.println("��� Ƚ���� �Է��ϼ���");
		this.roundNum = sc.nextInt();
	}
	
	public boolean nameVaild(String inputString) {
		this.car = inputString.split(",");
		
		for (int i = 0; i < car.length; i++) {
			if(car[i].length() > 5) {
				System.out.println("�Է��� �ڵ��� �̸� �߿� 5�ڸ� �ʰ��� �ֽ��ϴ�.");
				return true;
			}
		}
		return false;
	}
		
	public void makeRace() {
		
	}
	
	public void setGameNum() {
		
	}
	
	public void gameResult() {
		
	}
	public void gameWinner() {
		
	}
	
}
