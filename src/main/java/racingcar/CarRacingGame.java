package racingcar;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGame implements RacingGame {
    private final String RESULT_COMMENT = "실행 결과";
    private final String INTERMEDIATE_RESULT_APPEND_STRING = " : ";
    private final String INTERMEDIATE_RESULT_MOVE_STRING = "-";
    private final String RESULT_BEFORE_STRING = "최종 우승자: ";
    private final String RESULT_APPEND_STRING = ", ";
    private final int MOVE_ATTEMPT_COUNT_ZERO = 0;
    private final int RANDOM_MIN_VALUE = 0;
    private final int RANDOM_MAX_VALUE = 9;
    private final int NOT_MOVE_MAX_VALUE = 3;
    private final int INIT_MAX_MOVE = 0;

    private List<Car> carList = new ArrayList<>();

    public CarRacingGame() {
    }

    @Override
    public void addCar(Car car) {
        carList.add(car);
    }

    @Override
    public void startRacingGame(int carMoveAttemptCount) {
        if (carMoveAttemptCount <= MOVE_ATTEMPT_COUNT_ZERO) {
            return;
        }
        System.out.println(RESULT_COMMENT);
        for (int i = 0; i < carMoveAttemptCount; i++) {
            carsMoveOrStay();
            printIntermediateResult();
        }
        int maxMoveCount = findMaxMoveCount();
        List<String> winnerList = findWinner(maxMoveCount);
    }

    private int findMaxMoveCount() {
        int maxMoveCount = INIT_MAX_MOVE;
        for (int i = 0; i < carList.size(); i++) {
            final Car car = carList.get(i);
            if (maxMoveCount < car.getPosition()) {
                maxMoveCount = car.getPosition();
            }
        }
        return maxMoveCount;
    }

    private List<String> findWinner(int maxMoveCount) {
        List<String> winnerList = new ArrayList<>();
        for (int i = 0; i < carList.size(); i++) {
            final Car car = carList.get(i);
            if (maxMoveCount == car.getPosition()) {
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }

    private void carsMoveOrStay() {
        for (int i = 0; i < carList.size(); i++) {
            final int randomValue = RandomUtils.nextInt(RANDOM_MIN_VALUE, RANDOM_MAX_VALUE);
            if (randomValue > NOT_MOVE_MAX_VALUE) {
                final Car car = carList.get(i);
                car.increasePosition();
            }
        }
    }

    @Override
    public void printWinner() {
        final int maxMoveCount = findMaxMoveCount();
        List<String> winnerList = findWinner(maxMoveCount);
        StringBuilder resultBuilder = new StringBuilder(RESULT_BEFORE_STRING);
        for (int i = 0; i < winnerList.size(); i++) {
            final String name = winnerList.get(i);
            resultBuilder.append(name + RESULT_APPEND_STRING);
        }
        resultBuilder.delete(resultBuilder.length() - 2, resultBuilder.length());
        System.out.println(resultBuilder.toString());
    }

    private void printIntermediateResult() {
        for (int i = 0; i < carList.size(); i++) {
            final Car car = carList.get(i);
            StringBuilder intermediateResult = new StringBuilder(car.getName());
            intermediateResult.append(INTERMEDIATE_RESULT_APPEND_STRING);
            for(int j=0; j<car.getPosition(); j++) {
                intermediateResult.append("-");
            }
            System.out.println(intermediateResult.toString());
        }
        System.out.println();
    }
}
