package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.service.NumberToDashConverter;

import java.util.List;

public class OutputView {
    public static final String GAME_RESULT = "실행 결과";
    public static final String WINNERS = "최종 우승자: ";
    public static final int INDEX_VALUE_MIN = 0;

    public void showGameResult() {
        System.out.println();
        System.out.println(GAME_RESULT);
    }

    public void showEachRoundResult(List<String> carNames, List<Integer> carPositions) {

        for (int index = INDEX_VALUE_MIN; index < carNames.size(); index++) {
            System.out.println(carNames.get(index) + " : " + NumberToDashConverter.convert(carPositions.get(index)));
        }

        System.out.println();
    }

    public void showWinners(List<String> winners) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(WINNERS);
        stringBuilder.append(String.join(", ", winners));
        System.out.println(stringBuilder.toString());
    }
}
