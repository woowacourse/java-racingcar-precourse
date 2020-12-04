package racingcar;

public class Printer {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_NUMBER_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final String MOVING_RESULT_HEADER_MESSAGE = "실행 결과";
    private static final String OUTPUT_EACH_MOVING_RESULT_COLON = " : ";
    private static final String OUTPUT_EACH_MOVING_RESULT_BAR = "-";

    public void printInputCarNameMessage() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
    }

    public void printInputTryNumberMessage() {
        System.out.println(INPUT_TRY_NUMBER_MESSAGE);
    }

    public void printMovingResultHeader() {
        System.out.println(MOVING_RESULT_HEADER_MESSAGE);
    }

    public void printOutputEachResultPosition(String carName, int carPosition) {
        System.out.println(carName + OUTPUT_EACH_MOVING_RESULT_COLON + OUTPUT_EACH_MOVING_RESULT_BAR.repeat(carPosition));
    }

    public void printOutputFinalWinner() {
    }
}
