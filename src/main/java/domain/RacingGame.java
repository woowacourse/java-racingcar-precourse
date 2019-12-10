package domain;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class RacingGame {
	private List<String> carNames = new ArrayList<String>();
	private List<Car> cars = new ArrayList<Car>();
	private List<String> winners = new ArrayList<String>();
	private int repeateCount;
	public RacingGame(){
		
	};
	
	void setRepeateCount() {
		Scanner scanner = new Scanner(System.in);
		int count = 0;
		System.out.print("시도할 횟수는 몇회인가요?");
		//횟수가 맞대요! 구글에 물어봤답니다
		count = scanner.nextInt();
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
		//scan.close();
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
	int findMaxPosition() {
		int max = -1;
		List<Integer> positions = new ArrayList<Integer>();
		for(int i=0;i<getCarNamesSize();i++) {
			positions.add(cars.get(i).getPosition());
		}
		max = Collections.max(positions);
		return max;
	}
	void setWinningCarName(Car car,int max) {
		if(car.getPosition()==max) {
			winners.add(car.getName());
		}
	}
	void makeWinner() {
		for(int i=0;i<getCarNamesSize();i++) {
			setWinningCarName(cars.get(i), findMaxPosition());
		}
	}
	void printCarPosition(Car car) {
		String name = car.getName();
		int position = car.getPosition();
		System.out.print(name+" : ");
		for(int i=0;i<position;i++) {
			System.out.print("-");
		}
		System.out.println("");
	}
	void printCurrentCarsPosition() {
		for(int i=0;i<getCarNamesSize();i++) {
			printCarPosition(cars.get(i));
		}
	}
	void printWinner() {
		makeWinner();
		System.out.print(winners.get(0));
		if(winners.size()>1) {
			for(int i=1;i<winners.size();i++) {
				System.out.print(", "+winners.get(i));
			}
		}
	}
	void raceCars() {
		for(int i=0;i<getCarNamesSize();i++) {
			cars.get(i).race();
		}
		printCurrentCarsPosition();
	}
	void run() {
		setCarsName();
		makeCars();
		setRepeateCount();
		System.out.println("실행결과");
		for(int i=0;i<getRepeateCount();i++) {
			raceCars();
			System.out.println("");
		}
		System.out.println("");
		printWinner();
		System.out.println("(이)가 최종 우승했습니다");
	}
}
