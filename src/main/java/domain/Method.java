package domain;

import java.util.ArrayList;
import java.util.Scanner;

public class Method {

	static Car[] cars;
	Scanner scan = new Scanner(System.in);

	public void SetCarName() {
		String car;
		do {
			System.out.println("������ �ڵ��� �̸��� �Է��ϼ���.(�̸��� ��ǥ(,) �������� ����");
			car = scan.next();
		} while (SplitCarName(car));
		//InputRunCount();
	}

	private boolean SplitCarName(String car) {
		int i = 0;
		for (String num : car.split(",")) {
			if (!CheckStringLength(num)) {
				System.out.println("5�ڸ� �ʰ��ϼ̽��ϴ�");
				return true;
			}
			//cars[i] = new Car(num);
			i++;
		}
		return false;
	}

	private boolean CheckStringLength(String carName) {
		if(carName.length()<6)
			return true;

		return false;
	}

}
