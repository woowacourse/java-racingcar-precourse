package racing.display;

import racing.domain.Game;
import racing.domain.Winner;

public class OutputDisplay {
    private static final String RESULT = "\n실행결과";
    private static final String WINNER_PRINT_FORMAT = "%s가(이) 우승하였습니다.";

    public static void printWinners(Winner winner) {
        String names = winner.getNames();
        System.out.printf(WINNER_PRINT_FORMAT, names);
    }

    public static void printEachRoundResult(Game game) {
        StringBuilder stringBuilder = new StringBuilder();
        CharSequence currentCarsData = game.getCurrentInfo();
        stringBuilder.append(currentCarsData);

        System.out.println(stringBuilder);
    }

    public static void printResultMessage() {
        System.out.println(RESULT);
    }
}
