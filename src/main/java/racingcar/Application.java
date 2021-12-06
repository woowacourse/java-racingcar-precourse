package racingcar;

public class Application {
    public static void main(String[] args) {
        InputValidator inputValidator = new InputValidator();
        RacingGame racingGame = new RacingGame(inputValidator);
        racingGame.play();
    }
}