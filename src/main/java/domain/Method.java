package domain;

import java.util.ArrayList;
import java.util.Scanner;

public class Method {
	
	static ArrayList<Car> cars=new ArrayList<Car>();
	Scanner scan=new Scanner(System.in);
	
	public void SetCarName() {
		String car;
		do {
		System.out.println("������ �ڵ��� �̸��� �Է��ϼ���.(�̸��� ��ǥ(,) �������� ����");
		car=scan.next();
		}while(SplitCarName(car));
	}

	private boolean SplitCarName(String car) {
		
		for(String num : car.split(",")) {
			System.out.println(num);
		}
		
		return false;
	}
	
	
	
}
