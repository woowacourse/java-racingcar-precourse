package java;

import java.util.InputMismatchException;

public class test {
	public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();

        System.out.println("������ �ڵ��� �̸��� �Է��ϼ���.(�̸�����ǥ(,)�������α���)");
        try {
            System.out.println("������ �ڵ��� �̸��� �Է��ϼ���.(�̸�����ǥ(,)�������α���)");
            racingGame.inputCarName();
            System.out.println("�õ���ȸ���¸�ȸ�ΰ���?");
            racingGame.inputNumOfPlay();

        } catch (InputMismatchException e) {
            System.out.println("���ڰ� �ƴմϴ�.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
