package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.RacingCars;

public class OutputView {

    public static final String GAME_RESULT = "실행 결과";

    public static final String MOVE_SYMBOL = "-";

    public static final String NULL_CHARACTER = "\0";

    public void printRoundResult(RacingCars racingCars) {
        System.out.println(GAME_RESULT);

        for (Car racingCar : racingCars.getRacingCars()) {
            System.out.printf("%s : %s",
                    racingCar.getName(), repeatSymbol(racingCar.getPosition()));
        }

        System.out.println();
    }

    private String repeatSymbol(int times) {
        return new String(new char[times]).replace(NULL_CHARACTER, MOVE_SYMBOL);
    }
}
