package domain;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Method {

	static Car[] cars;
	String[] names;
	Random rd=new Random();
	Scanner scan = new Scanner(System.in);

	public void SetCarName() {
		String car;
		do {
			System.out.println("������ �ڵ��� �̸��� �Է��ϼ���.(�̸��� ��ǥ(,) �������� ����");
			car = scan.next();
		} while (SplitCarName(car));
		InputRunCount();
	}

	private boolean SplitCarName(String car) {
		names=car.split(",");
		cars=new Car[names.length];
		for (int i=0;i<names.length;i++) {
			if (!CheckStringLength(names[i])) {
				System.out.println("5�ڸ� �ʰ��ϼ̽��ϴ�");
				return true;
			}
			cars[i]=new Car(names[i]);
		}
		return false;
	}

	private void InputRunCount() {
		System.out.println("�õ��� Ƚ���� �� ȸ �ΰ���?");
		int runCount=scan.nextInt();
		printResult(runCount);
	}
	private void printResult(int runCount) {
		System.out.println();
		System.out.println();
		System.out.println("���� ���");
		for(int i=0;i<runCount;i++) {
			runResult();
		}
		
	}

	private boolean CheckStringLength(String carName) {
		if(carName.length()<6)
			return true;

		return false;
	}
	
	public boolean checkForward() {
		if(RandomNumber()<4)
			return false;
		return true;
			
	}
	
	private  int RandomNumber() {
		return rd.nextInt(9)+1;	
	}
	
	
	public void runResult() {
		for(int i=0;i<cars.length;i++) {
			System.out.print(cars[i].getName()+":");
			if(checkForward())
				cars[i].setPosition(checkForward());
			printCarPosition(i);
			System.out.println();
		}
		System.out.println();
	}

	private void printCarPosition(int index) {
		for(int i=0;i<cars[index].getPosition();i++) {
			System.out.print("-");
		}
	}

}
