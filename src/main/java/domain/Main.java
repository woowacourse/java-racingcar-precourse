package domain;

import java.util.Scanner;

public class Main {
	static int maxPosition;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int round = 0;
		String names[] = null;
		Car[] racingCars = null;
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.print("������ �ڵ��� �̸��� �Է��ϼ���.");
			System.out.println("(�̸��� ��ǥ(,)�� �������� ����)");
			names = sc.next().split(",");
			
			if(isEffectiveFormat(names)) { 
				break;
			}
		}
		
		racingCars = new Car[names.length];
		for (int i = 0; i < racingCars.length; i++) {
			racingCars[i] = new Car(names[i]); 
		}
		
		System.out.println("�õ��� ȸ���� ��ȸ�ΰ���?");
		round = sc.nextInt();
		
		gameStart(racingCars,1,round);
		gameFisish();
		
		sc.close();
	}

	private static void gameStart(Car[] cars,int now, int total) {
		for (int i = 0; i < cars.length; i++) {
			cars[i].run();
			cars[i].printState();
			calMax(cars[i].getPosition());
		}
		
		if (now < total) {
			gameStart(cars, now+1, total);
		}
	}

	private static boolean isEffectiveFormat(String[] names) {
		boolean result = true;
		
		for (int i = 0; i < names.length; i++) {
			if (names[i].length()>5) {
				System.out.println("5�ڰ� �Ѿ�� �̸��� �ֽ��ϴ�.");
				result = false;
				break;
			}
		}
		return result;
	}
	
	private static void gameFisish() {
		StringBuffer sb = new StringBuffer();
		sb.append("�� ��������߽��ϴ�.\n");
		System.out.println(sb.toString());
	}
	
	private static void calMax(int position) {
		if (position > maxPosition) {
			maxPosition = position;
		}
	}
}
