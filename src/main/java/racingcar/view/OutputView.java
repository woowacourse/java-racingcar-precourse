package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.RacingCars;

public final class OutputView {

    private static final String GAME_RESULT = "\n실행 결과";

    private static final String FINAL_WINNERS = "최종 우승자: ";

    private static final String MOVE_SYMBOL = "-";

    private static final String NULL_CHARACTER = "\0";

    private static final String WINNER_DELIMITER = ", ";

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
        System.out.println(FINAL_WINNERS + String.join(WINNER_DELIMITER, racingCars.findWinners()));
    }

    private String repeatSymbol(final int times) {
        return new String(new char[times]).replace(NULL_CHARACTER, MOVE_SYMBOL);
    }
}
