package racingcar;

import java.io.PrintStream;
import java.util.ArrayList;

public class Response {
    private static final String NAMES_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String NUMBER_ROUND_REQUEST_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RACE_START_MESSAGE = "실행 결과";
    private static final String CAR_SITUATION_MESSAGE_FORMAT = "%s : %s%n";
    private static final String WINNERS_MESSAGE_FORMAT = "최종 우승자: %s%n";
    private static final String PROGRESS_BAR = "-";
    private static final String LIST_SEPARATOR = ", ";
    private static final String EMPTY_MESSAGE = "";
    private final PrintStream printStream;

    public Response(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void printNamesRequestMessage() {
        printStream.println(NAMES_REQUEST_MESSAGE);
    }

    public void printNumberStageRequestMessage() {
        printStream.println(NUMBER_ROUND_REQUEST_MESSAGE);
    }

    public void printPrepareEndMessage() {
        printStream.println(EMPTY_MESSAGE);
    }

    public void printRaceStartMessage() {
        printStream.println(RACE_START_MESSAGE);
    }

    public void printRaceSituation(ArrayList<Car> cars) {
        for (Car car : cars) {
            printCarSituation(car);
        }
        printStream.println(EMPTY_MESSAGE);
    }

    private void printCarSituation(Car car) {
        printStream.printf(CAR_SITUATION_MESSAGE_FORMAT, car.getCarName(),
                createProgressBar(car.getPosition()));
    }

    private String createProgressBar(int length) {
        return PROGRESS_BAR.repeat(length);
    }

    public void printWinners(Winners winners) {
        printStream.printf(WINNERS_MESSAGE_FORMAT, convertCarListToString(winners.getCars()));
    }

    public String convertCarListToString(ArrayList<Car> cars) {
        String result = "";
        for (int i = 0; i < cars.size(); i++) {
            result += cars.get(i).getCarName();
            if (i != cars.size() - 1) {
                result += LIST_SEPARATOR;
            }
        }
        return result;
    }
}
