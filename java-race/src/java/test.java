package java;

import java.util.InputMismatchException;

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

	        } catch (InputMismatchException e) {
	            System.out.println("���ڰ� �ƴմϴ�.");
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}
