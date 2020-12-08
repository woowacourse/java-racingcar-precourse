package racingcar;

public class OutputView {
    private static final String RACING_START_MESSAGE = "실행 결과";
    private static final String RACING_FINISH_MESSAGE = "최종 우승자";
    private static final String MOVE_FORWARD = "-";
    private static final String COLON_AFTER_CAR_NAME = " : ";

    public void printRacingStartMessage() {
        System.out.println(RACING_START_MESSAGE);
    }

    public void printRoundResult(CarGroup carGroup) {
        for (Car car : carGroup.getCarGroup()) {
            System.out.println(car.getName() + COLON_AFTER_CAR_NAME + printMoveDistance(car));
        }
        System.out.println();
    }

    private String printMoveDistance(Car car) {
        String moveDistance = "";
        for (int i = 0; i < car.getPosition(); i++) {
            moveDistance = moveDistance.concat(MOVE_FORWARD);
        }
        return moveDistance;
    }

    public void printFinalWinner(String finalWinner) {
        System.out.println(RACING_FINISH_MESSAGE + COLON_AFTER_CAR_NAME + finalWinner);
    }
}
