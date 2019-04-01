package domain;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int round;
		String names[];
		Car[] racingCars;
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.print("������ �ڵ��� �̸��� �Է��ϼ���.");
			System.out.println("(�̸��� ��ǥ(,)�� �������� ����)");
			names = sc.next().split(",");
			
			if(!isEffectiveFormat(names)) continue;
			//names�� Car ��ü���� �����ڵ� �߰�.
			
			break;
		}
		System.out.println("�õ��� ȸ���� ��ȸ�ΰ���?");
		round = sc.nextInt();
		
		//round��ŭ ���� ���� �ڵ� �߰�
		//���� ������ ��� ����ϴ� �ڵ� �߰�
		
		sc.close();
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
	
}
