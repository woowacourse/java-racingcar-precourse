package racingcar.view;

import racingcar.domain.dto.CarDto;

import java.util.List;

public class OutputView {
    private static final String GAME_EXECUTION_RESULT_HEADER_MESSAGE = "\n실행 결과";
    private static final String EACH_CAR_RACING_TRY_RESULT_MESSAGE = "%s : %s\n";
    private static final String WINNER_CAR_NAMES_MESSAGE = "최종 우승자 : %s\n";
    private static final String WINNER_CAR_NAMES_DELIMITER = ", ";
    private static final String DISTANCE_DASH_MARK = "-";
    private static final int ZERO_INDEX = 0;

    private OutputView() {
    }

    public static void printGameExecutionResultHeader() {
        System.out.println(GAME_EXECUTION_RESULT_HEADER_MESSAGE);
    }

    public static void printRacingTryResult(List<CarDto> carDtos) {
        carDtos.forEach(OutputView::printEachCarRacingResult);
        System.out.println();
    }

    private static void printEachCarRacingResult(CarDto carDto) {
        String carName = carDto.getName();
        int position = carDto.getPosition();
        String movingDistance = drawMovingDistance(position);
        System.out.printf(EACH_CAR_RACING_TRY_RESULT_MESSAGE, carName, movingDistance);
    }

    private static String drawMovingDistance(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = ZERO_INDEX; i < position; i++) {
            stringBuilder.append(DISTANCE_DASH_MARK);
        }
        return stringBuilder.toString();
    }
}
