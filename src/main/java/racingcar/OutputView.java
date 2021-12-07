package racingcar;

import java.util.List;

public class OutputView {
    public static void printPosition(Car car) {
        System.out.print(car.getName() + RacingCarConstant.COLON);
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(RacingCarConstant.MOVE_MARK);
        }
        System.out.println();
    }

    public static void printResultMessage() {
        System.out.println(RacingCarConstant.RESULT_MESSAGE);
    }

    public static void printWinnerList(List<String> winnerList) {
        System.out.print(RacingCarConstant.WINNER_RESULT_MESSAGE);
        System.out.print(String.join(RacingCarConstant.DELIMITER + RacingCarConstant.BLANK, winnerList));
    }
}
