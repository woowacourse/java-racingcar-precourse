package java;

public class test {
	public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();

        System.out.println("������ �ڵ��� �̸��� �Է��ϼ���.(�̸�����ǥ(,)�������α���)");
        try {
            racingGame.inputCarName();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
