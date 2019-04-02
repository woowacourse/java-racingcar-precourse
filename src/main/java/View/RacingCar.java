package View;

public class RacingCar {

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();

        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은쉼표(,)기준으로구분)");
            racingGame.inputCarName();

            System.out.println("시도할 회수는 몇회인가요?");
            racingGame.inputNum();

            System.out.println("\n시행 결과");
            racingGame.play();

            racingGame.displayResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

