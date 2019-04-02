package baeminHW2;
import java.io.InputStream;
import java.util.Scanner;

public class racingcar {
	public static void main(String[] args) {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기분으로 구분)");

	}
	
	
	public static String[] getCarName() {
		Scanner scan = new Scanner(System.in);
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기분으로 구분)");
		String carName = scan.nextLine();
		return carName.split(",");
	}
}




