package racingcar;

public class Application {
    public static void main(String[] args) {
        User user = new User();
        Game game = new Game();

        String[] nameList = user.inputCarName();
        int roundNumber = user.inputRoundNumber();

        game.startGame(nameList, roundNumber);
    }
}
