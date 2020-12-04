package racingcar.view;

import java.util.stream.IntStream;

/**
 * 주어진 결과를 출력하는 클래스
 */
public class OutputGuide {

    private static final String SHOW_STATUS_LOG = "실행 결과";
    private static final String WINNER_IS = "최종 우승자: ";
    private static final String COLON = " : ";
    private static final String POSITION_DASH = "-";
    private static final int MIN = 0;

    public void showResult() {
        System.out.println(SHOW_STATUS_LOG);
    }

    public void showWinner(String winners) {
        System.out.println(WINNER_IS + winners);
    }

    public void drawTrace(String car, int position) {
        StringBuilder carPosition = new StringBuilder();
        carPosition.append(car).append(COLON);
        IntStream.range(MIN, position)
            .forEach(value -> carPosition.append(POSITION_DASH));
        System.out.println(carPosition.toString());
    }
}
