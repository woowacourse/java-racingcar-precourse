package java;

import domain.Car;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class test {
	  public static void main(String[] args) {
	        RacingGame racingGame = new RacingGame();
	        Scanner sc = new Scanner(System.in);

	        try {
	            System.out.println("������ �ڵ��� �̸��� �Է��ϼ���.(�̸�����ǥ(,)�������α���)");
	            racingGame.inputCarName();
	            System.out.println("�õ���ȸ���¸�ȸ�ΰ���?");
	            racingGame.inputNumOfPlay();

	            System.out.println("�õ��� ȸ���� ��ȸ�ΰ���?");
	            int count = sc.nextInt();

	            System.out.println("\n���� ���");
	            for (int i = 0; i < count; i++) {
	                racingGame.play();
	                racingGame.displayCarPosition();
	                System.out.println();
	            }

	        } 
	        
	        List<Car> carList = racingGame.getResult();
            for (int i = 0; i < carList.size(); i++) {
                System.out.print(carList.get(i).getName());
                if ( i != carList.size()-1) {
                    System.out.print(", ");
                }

            }
            System.out.println("�� ���� ����߽��ϴ�.");

        }
	        
	        catch (InputMismatchException e) {
	            System.out.println("���ڰ� �ƴմϴ�.");
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}
