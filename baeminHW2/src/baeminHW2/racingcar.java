package baeminHW2;
import java.util.Scanner;

public class racingcar {
	public static void main(String[] args) {
		String[] carName = getCarName();
		int recingTime = getRacingTime();
	}
	
	
	public static String[] getCarName() {
		Scanner scan = new Scanner(System.in);
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기분으로 구분)");
		String carName = scan.nextLine();
		return carName.split(",");
	}
	
	public static int getRacingTime() {
		Scanner scan = new Scanner(System.in);
		System.out.println("시도할 회수는 몇회인가요?");
		int racingTime = scan.nextInt();
		return racingTime;
	}
}




