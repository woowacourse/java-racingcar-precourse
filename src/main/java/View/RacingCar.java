package View;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RacingCar {

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은쉼표(,)기준으로구분)");
            racingGame.inputCarName();

            System.out.println("시도할 회수는 몇회인가요?");
            int count = sc.nextInt();

            System.out.println("\n시행 결과");
            for (int i = 0; i < count; i++) {
                racingGame.play();
                racingGame.displayCarPosition();
                System.out.println();
            }

        } catch (InputMismatchException e) {
            System.out.println("숫자가 아닙니다.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}

