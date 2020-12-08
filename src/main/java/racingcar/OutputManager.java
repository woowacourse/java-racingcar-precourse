package racingcar;

import java.util.List;

public class OutputManager {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_NUMBER_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final String MOVING_RESULT_HEADER_MESSAGE = "실행 결과";
    private static final String OUTPUT_EACH_MOVING_RESULT_COLON = " : ";
    private static final String OUTPUT_EACH_MOVING_RESULT_BAR = "-";
    private static final String OUTPUT_FINAL_WINNER_MESSAGE = "최종 우승자: ";
    private static final String OUTPUT_FINAL_WINNER_COMMA = ", ";

    public void printInputCarNamesMessage() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
    }

    public void printInputTryNumberMessage() {
        System.out.println(INPUT_TRY_NUMBER_MESSAGE);
    }

    public void printMovingResultHeader() {
        System.out.println(MOVING_RESULT_HEADER_MESSAGE);
    }

    public void printOutputEachResultPosition(String carName, int carPosition) {
        printCarName(carName);
        printCarPosition(carPosition);
    }

    public void printOutputFinalWinner(List<String> winnerNameList) {
        System.out.print(OUTPUT_FINAL_WINNER_MESSAGE);
        for (int i = 0; i < winnerNameList.size(); i++) {
            System.out.print(winnerNameList.get(i));
            if (i < winnerNameList.size() - 1) {
                System.out.print(OUTPUT_FINAL_WINNER_COMMA);
            }
        }
    }

    private void printCarName(String carName) {
        System.out.print(carName + OUTPUT_EACH_MOVING_RESULT_COLON);
    }

    private void printCarPosition(int carPosition) {
        System.out.println(OUTPUT_EACH_MOVING_RESULT_BAR.repeat(carPosition));
    }
}

