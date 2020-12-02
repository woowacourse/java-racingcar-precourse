package racingcar.view;

import java.util.Collections;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.race.Race;

public final class OutputView {

    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_MOVING_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_PREFIX_MESSAGE = "최종 우승자: ";
    private static final String COLON = " : ";
    private static final String DISTANCE = "-";
    private static final String DELIMITER = "";
    private static final String COMMA = ", ";

    private OutputView() {
    }

    public static OutputView basic() {
        return new OutputView();
    }

    public void printInputCarNamesMessage() {
        println(INPUT_CAR_NAMES_MESSAGE);
    }

    public void printInputMovingCountMessage() {
        println(INPUT_MOVING_COUNT_MESSAGE);
    }

    public void printResultMessage() {
        println();
        println(RESULT_MESSAGE);
    }

    public void printRaceTrack(final Race race) {
        race.getCars().forEach(car -> {
            String line = String.join(DELIMITER, Collections.nCopies(car.getPosition(), DISTANCE));
            println(car.getName() + COLON + line);
        });
        println();
    }

    public void printWinnerCars(final Race race) {
        String firstPlaceCarNamesStr = race.getFirstPlaceCars().stream()
            .map(Car::getName)
            .collect(Collectors.joining(COMMA));

        println(WINNER_PREFIX_MESSAGE + firstPlaceCarNamesStr);
    }

    public void println(final String value) {
        System.out.println(value);
    }

    public void println() {
        System.out.println();
    }
}
