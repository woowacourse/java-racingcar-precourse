package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.RacingCars;

public final class OutputView {

    public static final String GAME_RESULT = "\n실행 결과";

    public static final String MOVE_SYMBOL = "-";

    public static final String NULL_CHARACTER = "\0";

    public static final String FINAL_WINNERS = "최종 우승자: ";

    public static final int OPEN_BRACKET_INDEX = 1;

    public void printGameResult() {
        System.out.println(GAME_RESULT);
    }

    public void printRoundResult(final RacingCars racingCars) {
        for (Car racingCar : racingCars.getRacingCars()) {
            System.out.printf("%s : %s\n",
                    racingCar.getName(), repeatSymbol(racingCar.getPosition()));
        }

        System.out.println();
    }

    public void printWinners(final RacingCars racingCars) {
        String winners = racingCars.findWinners().toString();
        String removedBracketWinners = winners.substring(OPEN_BRACKET_INDEX, winners.length() - 1);
        System.out.println(FINAL_WINNERS + removedBracketWinners);
    }

    private String repeatSymbol(final int times) {
        return new String(new char[times]).replace(NULL_CHARACTER, MOVE_SYMBOL);
    }
}
