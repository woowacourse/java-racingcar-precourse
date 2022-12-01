package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printInputCarNameMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printInputTryNumberMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printGameResultMessage() {
        System.out.println("실행 결과");
        System.out.println();
    }

    public void printForwardTryResult(List<Map<String, String>> triedCarsInfo) {
        for (Map<String, String> triedCarInfo : triedCarsInfo) {
            String carName = triedCarInfo.get("name");
            String position = triedCarInfo.get("position");
            System.out.println(carName + " : " + position);
        }
        System.out.println();
    }

    public void printFinalWinners(List<String> finalWinners) {
        String winners = String.join(", ", finalWinners);
        System.out.println("최종 우승자 : " + winners);
    }
}
