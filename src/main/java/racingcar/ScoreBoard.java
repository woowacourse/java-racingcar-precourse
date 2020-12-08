package racingcar;

import java.util.StringJoiner;

import static utils.TextResource.WORD_WINNER;

public class ScoreBoard {

    public static final String POSITION_VIEW = " -";
    public static final String NAME_VALUE_SEPARATOR = " : ";

    public void printCurrentRacingStatus(Cars participants) {
        for (Car car : participants.getCars()) {
            System.out.print(car.getName());
            System.out.print(NAME_VALUE_SEPARATOR);
            printPosition(car.getPosition());
            System.out.println();
        }
        System.out.println();
    }

    public void printWinner(Cars winners) {
        StringJoiner stringJoiner = new StringJoiner(",");
        for (Car car : winners.getCars()) {
            stringJoiner.add(car.getName());
        }
        System.out.println(WORD_WINNER + NAME_VALUE_SEPARATOR + stringJoiner.toString());
    }

    private void printPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print(POSITION_VIEW);
        }
    }
}
