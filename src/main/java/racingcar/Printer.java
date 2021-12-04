package racingcar;

import static java.lang.String.join;
import static racingcar.Messages.NAME_INPUT_INFO_MESSAGE;
import static racingcar.Messages.ROUND_INPUT_INFO_MESSAGE;
import static racingcar.Messages.WINNER_INFO_MESSAGE;

import java.util.List;

public class Printer {

    private static final String BAR = "-";
    private static final String SEPARATOR = " : ";
    private static final String WINNER_SEPARATOR = ", ";

    public void printInputNameInfo() {
        System.out.println(NAME_INPUT_INFO_MESSAGE.getMessage());
    }

    public void printInputRoundInfo() {
        System.out.println(ROUND_INPUT_INFO_MESSAGE.getMessage());
    }

    public void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public void printMiddleResult(List<Car> cars) {
        System.out.println();

        for (Car car : cars) {
            System.out.print(car.getName() + SEPARATOR);
            printBar(car.getPosition());
        }

        System.out.println();
    }

    public void printWinner(List<String> winners) {
        System.out.print(WINNER_INFO_MESSAGE.getMessage());
        System.out.println(join(WINNER_SEPARATOR, winners));
    }

    private void printBar(int position) {
        StringBuilder bars = new StringBuilder();

        for (int i = 0; i < position; i++) {
            bars.append(BAR);
        }

        System.out.println(bars);
    }
}
