package racingcar;

import java.util.ArrayList;

public class RacingGamePrinter implements IRacingGamePrinter {
    private static final String INPUT_PLAYER_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";
    private static final String ERROR_PLAYER_NAME = "[ERROR] 자동차 이름은 1자 이상 5자 이하만 가능합니다.\n";
    private static final String INPUT_OPTION = "시도할 회수는 몇회인가요?\n";
    private static final String ERROR_OPTION = "[ERROR] 시도 횟수는 1 이상 2,147,483,647 이하의 숫자여야 합니다.\n";
    private static final String NEW_LINE = "\n";
    private static final String START = "실행 결과\n";
    private static final String SCORE_GUIDE = " : ";
    private static final String DISTANCE = "-";

    @Override
    public void inputNames() {
        System.out.print(INPUT_PLAYER_NAME);
    }

    @Override
    public void errorInputPlayer() {
        System.out.print(ERROR_PLAYER_NAME);
    }

    @Override
    public void inputReps() {
        System.out.print(INPUT_OPTION);
    }

    @Override
    public void errorInputReps() {
        System.out.print(ERROR_OPTION);
    }

    @Override
    public void start() {
        System.out.print(NEW_LINE + START);
    }

    @Override
    public void status(ArrayList<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + SCORE_GUIDE);
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print(DISTANCE);
            }
            System.out.print(NEW_LINE);
        }
        System.out.print(NEW_LINE);
    }

    @Override
    public void winner(ArrayList<Car> cars) {
    }
}