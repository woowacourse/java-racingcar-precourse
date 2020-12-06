package racingcar.controller.view;

import racingcar.domain.car.Car;
import racingcar.domain.setting.Message;

import java.util.List;
import java.util.stream.Collectors;

public class ConsoleView implements ViewController {

    private static final StringBuilder stringBuilder = new StringBuilder();

    private static final String NEW_LINE = "\n";
    private static final String NAME_SEPARATOR = ", ";

    static {
        stringBuilder.append(Message.RESULT_MESSAGE);
    }

    @Override
    public void recordCarsPosition(String carsPositon) {
        stringBuilder.append(carsPositon);
        appendBlankLine();
    }

    @Override
    public void recordWinner(List<Car> winners) {
        stringBuilder.append(Message.WINNER_MESSAGE);

        String winnerName = winners.stream()
                .map(car -> car.toString())
                .collect(Collectors.joining(NAME_SEPARATOR));

        stringBuilder.append(winnerName);
    }

    private void appendBlankLine() {
        stringBuilder.append(NEW_LINE);
        stringBuilder.append(NEW_LINE);
    }


    @Override
    public void printResult() {
        System.out.println(stringBuilder.toString());
    }

}
