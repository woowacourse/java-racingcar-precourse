package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String INPUT_CAR_NAME_MESSAGE = "자동차 이름을 5자 이하로 콤마로 구분하여 입력해주세요.";
    private static final String INPUT_TRIAL_MESSAGE = "시도할 횟수를 입력해주세요.";
    private static final String RACE_RESULT_HEADER = "실행 결과";
    private static final String FORWARD_FLAG = "-";
    private static final String CAR_RESULT_FORMAT = "%s : %s";
    private static final String WINNER_FORMAT = "최종 우승자 : ";
    private static final String WINNER_DELIMITER = ", ";
    private static final String DELIMITER = "\n";

    public void printInputCarNameMessage() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
    }

    public void printInputTrialMessage() {
        System.out.println(INPUT_TRIAL_MESSAGE);
    }

    public void printRaceResultHeader() {
        System.out.println(RACE_RESULT_HEADER + DELIMITER);
    }

    public void printRaceResult(Cars cars) {
        String result = cars.getCars().stream()
                .map(this::raceResult)
                .collect(Collectors.joining(DELIMITER));

        System.out.println(result + DELIMITER);
    }

    private String raceResult(Car car) {
        String name = car.getName();
        int position = car.getPosition();
        return String.format(CAR_RESULT_FORMAT, name, getForward(position));
    }

    private String getForward(int position) {
        return FORWARD_FLAG.repeat(position);
    }

    public void printRaceWinner(List<String> winner) {
        System.out.println(WINNER_FORMAT + String.join(WINNER_DELIMITER, winner));
    }
}
