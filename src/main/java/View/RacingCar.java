package View;

public class RacingCar {

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은쉼표(,)기준으로구분)");
        try {
            racingGame.inputCarName();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

}

