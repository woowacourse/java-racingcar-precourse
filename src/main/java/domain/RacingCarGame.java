package domain;

public class RacingCarGame {

    public static void main(String[] args) {
        Controller controller = new Controller();

        controller.askCarsName();
        controller.askNumberOfAttempts();
        controller.startGame();

        System.out.println("\n실행 결과");

        for (int i = 0; i < controller.getLaps(); i++) {
            controller.checkCarsPosition();
        }

        controller.checkWinner();
    }

}
