package racingcar;

public class Application {
    public static void main(String[] args) {
        User user = new User();
        Game game = new Game();

        user.informInputCar();
        String[] nameList = user.inputCarName();

        user.informInputCount();
        int roundNumber = user.inputRoundNumber();

        game.startGame(nameList, roundNumber);
    }
}
