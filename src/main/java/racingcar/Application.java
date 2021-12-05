package racingcar;

public class Application {
    public static void main(String[] args) {
        User user = new User();
        Game game = new Game();

        user.informInputCar();
        String[] nameList = user.inputCarName();

        user.informInputCount();
        int attemptCount = user.inputRepeatNumber();

        game.startGame(nameList, attemptCount);
    }
}
