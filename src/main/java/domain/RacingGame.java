package domain;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {
	private List<String> carNames = new ArrayList<String>();
	private List<Car> cars = new ArrayList<Car>();
	private int repeateCount;
	public RacingGame(){
		
	};
	
	void setRepeateCount() {
		Scanner scan = new Scanner(System.in);
		int count = 0;
		System.out.println("시도할 횟수는 몇회인가요?");
		//횟수가 맞대요! 구글에 물어봤답니다
		count = scan.nextInt();
		this.repeateCount = count;
	}
	void setCarsName() {
		Scanner scan = new Scanner(System.in);
		String nameString;
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		nameString = scan.nextLine();
		String[] nameArray = nameString.split(",");
		for(int i=0;i<nameArray.length;i++) {
			carNames.add(nameArray[i]);
		}
		scan.close();
	}
	String getCarName(int index) {
		return this.carNames.get(index);
	}
	int getCarNamesSize() {
		return this.carNames.size();
	}
	int getRepeateCount() {
		return this.repeateCount;
	}
	void makeCars() {
		for(int i=0;i<getCarNamesSize();i++) {
			Car tmpCar = new Car(getCarName(i));
			cars.add(tmpCar);
		}
	}
	boolean checkNameLength(String name) {
		return name.length()<=5;
	}
	int makeRandomNumber() {
		Random random = new Random();
		return random.nextInt(10);
		//make random number in range 0~9;
	}
	boolean shouldGo(int randomNumber) {
		return randomNumber>3;
		//more than 4 : go, less than 3 : stop
	}
}
