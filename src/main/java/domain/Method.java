package domain;

import java.util.ArrayList;
import java.util.Scanner;

public class Method {
	
	static ArrayList<Car> cars=new ArrayList<Car>();
	Scanner scan=new Scanner(System.in);
	
	public void SetCarName() {
		System.out.println("������ �ڵ��� �̸��� �Է��ϼ���.(�̸��� ��ǥ(,) �������� ����");
		String cars=scan.next();
		SplitCarName(cars);
	}
	
	
	
}
