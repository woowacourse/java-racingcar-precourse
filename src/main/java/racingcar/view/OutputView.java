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
    }

    private String positionMap(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
