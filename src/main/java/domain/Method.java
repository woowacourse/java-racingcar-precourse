package domain;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Method {

	static Car[] cars;
	Random rd=new Random();
	Scanner scan = new Scanner(System.in);

	public void SetCarName() {
		String car;
		do {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
			car = scan.next();
		} while (SplitCarName(car));
		//InputRunCount();
	}

	private boolean SplitCarName(String car) {
		int i = 0;
		for (String name : car.split(",")) {
			if (!CheckStringLength(name)) {
				System.out.println("5자를 초과하셨습니다");
				return true;
			}
			//cars[i] = new Car(name);
			i++;
		}
		return false;
	}

	private void InputRunCount() {
		System.out.println("시도할 횟수는 몇 회 인가요?");
		int runCount=scan.nextInt();
		printResult(runCount);
	}
	private boolean CheckStringLength(String carName) {
		if(carName.length()<6)
			return true;

		return false;
	}
	
	public boolean CheckForward() {
		if(RandomNumber()<4)
			return false;
		return true;
			
	}
	
	private  int RandomNumber() {
		return rd.nextInt(9)+1;	
	}
	public void printResult(int count) {
		for(int i=0;i<count;i++) {
			
		}
	}

}
