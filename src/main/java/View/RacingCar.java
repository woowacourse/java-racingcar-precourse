package View;

import java.util.InputMismatchException;

public class RacingCar {

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();

        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은쉼표(,)기준으로구분)");
            racingGame.inputCarName();
            System.out.println("시도할회수는몇회인가요?");
            racingGame.inputNumOfPlay();

        } catch (InputMismatchException e) {
            System.out.println("숫자가 아닙니다.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}

