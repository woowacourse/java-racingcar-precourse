package baeminHW2;
import java.util.Scanner;

public class racingcar {
	public static void main(String[] args) {
		String[] carName = getCarName();
		int racingTime = getRacingTime();
		Car[] cars = setCars(carName);
		racing(cars, racingTime);
		printWinners(cars);
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
	
	public static Car[] setCars(String[] name) {
		Car[] cars = new Car[name.length];
		for(int i=0; i<name.length; i++) {
			Car temp = new Car(name[i]);
			cars[i] = temp;
		}
		return cars;
	}
	
	public static void racing(Car[] cars, int time) {
		int[] res = new int[cars.length];
		int max=0;
		System.out.println("\n실행결과");
		for(int i=0; i<time; i++) {
			for(int j=0; j<cars.length; j++) {
				cars[j].goOrStop();
			}
			System.out.println("");
		}
	}
	
	public static void printWinners(Car[] cars) {
		int max =0;
		for(int i=0; i<cars.length; i++) {
			if(max < cars[i].getPosition()) {
				max = cars[i].getPosition();
			}
		}
		for(int i=0; i<cars.length; i++) {
			if(cars[i].getPosition() == max) {
				System.out.print(cars[i].getName() + ", ");
			}
		}
		System.out.println("\b \b가 최종 우승했습니다.");
	}
}