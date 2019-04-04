import domain.RacingCarGame;
import tokenizer.CommaTokenizer;
import tokenizer.Tokenizer;

import java.util.List;

public class RacingCar {
    public static void main(String[] args) {
        final String carNamesWithComma = UserInterface.getCarNamesWithComma();
        final int remainingPlayCount = UserInterface.getRemainingPlayCount();

        final Tokenizer tokenizer = new CommaTokenizer();
        final List<String> carNames = tokenizer.tokenize(carNamesWithComma);

        final RacingCarGame racingCarGame = RacingCarGame.of(carNames, remainingPlayCount);
        racingCarGame.play();

        UserInterface.printRecords(racingCarGame.getRecords());
        UserInterface.printWinners(racingCarGame.getWinners());
    }
}
