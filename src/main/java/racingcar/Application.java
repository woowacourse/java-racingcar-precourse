package racingcar;

public class Application {

    public static void main(String[] args) {
        // TODO 구현 진행
        RacingGame racingGame = new RacingGame(
                new UserInput(),
                new Validator(),
                new GameDisplay()
        );

        racingGame.startGame();
    }
}
