package domain;

import java.util.ArrayList;
import java.util.Scanner;

public class Method {
	
	static Car[] cars;
	Scanner scan=new Scanner(System.in);
	
	public void SetCarName() {
		String car;
		do {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기중으로 구분");
		car=scan.next();
		}while(SplitCarName(car));
	}

	private boolean SplitCarName(String car) {
		int i=0;
		for(String num : car.split(",")) {
			cars[i]=new Car(num);
			i++;
		}	
		if(CheckStringLength());
			SetCarName();
		InputRunCount();	
	}
	
	
	
}
