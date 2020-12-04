package racingcar;

import java.util.List;

public class OutputView {
    private static final String RACING_START_MESSAGE = "실행 결과";
    private static final String RACING_FINISH_MESSAGE = "최종 우승자";
    private static final String MOVE_FORWARD = "-";
    private static final String COLON_AFTER_CAR_NAME = " : ";

    private String finalWinner;
    private final Racing racing;

    public OutputView(Racing racing) {
        this.racing = racing;
    }

    public void printRacingStartMessage() {
        System.out.println(RACING_START_MESSAGE);
    }

    public void printRoundResult() {
        for (Car car : racing.getCarList()) {
            System.out.println(car.getName() + COLON_AFTER_CAR_NAME + printMoveDistance(car.getPosition()));
        }
        System.out.println();
    }

    private String printMoveDistance(int position) {
        String moveDistance = "";
        for (int i = 0; i < position; i++) {
            moveDistance = moveDistance.concat(MOVE_FORWARD);
        }
        return moveDistance;
    }

    public void printFinalWinner(List<String> finalwinnerNameList) {
        finalWinner = String.join(", ", finalwinnerNameList);
        System.out.println(RACING_FINISH_MESSAGE + COLON_AFTER_CAR_NAME + finalWinner);
    }
}
