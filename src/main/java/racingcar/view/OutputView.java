package racingcar.view;

import java.util.List;
import racingcar.domain.RacingResult;

public class OutputView {

    public void printWay(RacingResult result) {
        List<String> carNames = result.getCarNames();
        for (String carName : carNames) {
            int position = result.getPosition(carName);
            System.out.println(carName + " : " + positionMap(position));
        }
        System.out.println();
    }

    private String positionMap(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public void printWinner(RacingResult winner) {
        String collect = String.join(", ", winner.getCarNames());
        System.out.println("최종 우승자 : " + collect);
    }

    public void printError(String message) {
        System.out.println("[ERROR] " + message);
    }
}
