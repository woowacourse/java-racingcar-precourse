package domain;

import java.util.ArrayList;
import java.util.Scanner;

public class Method {
	
	static ArrayList<Car> cars=new ArrayList<Car>();
	Scanner scan=new Scanner(System.in);
	
	public void SetCarName() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기중으로 구분");
		String cars=scan.next();
		SplitCarName(cars);
	}
	
	
	
}
