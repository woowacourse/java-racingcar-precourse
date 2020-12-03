package racingcar;

import utils.RandomUtils;
import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final int RANDOM_START_VALUE = 0;
    private static final int RANDOM_END_VALUE = 10;
    private static final int GO_FORWARD_VALUE = 4;

    List<Car> cars;

    public Cars(List<String> names) {
        cars = names.stream().map(Car::new).collect(Collectors.toList());
    }

    private boolean isGoForward() {
        return RandomUtils.nextInt(RANDOM_START_VALUE, RANDOM_END_VALUE) >= GO_FORWARD_VALUE;
    }

    // 재귀를 통해 게임 시도 회수 까지 레이스 실행
    public int doRace(int tryTimes) {
        if (tryTimes <= 0) {
            return tryTimes;
        }

        for (Car car : cars) {
            applyNewCarPosition(car);
        }

        return doRace(--tryTimes);
    }

    public void applyNewCarPosition(Car car) {
        if (isGoForward()) {
            car.goForward();
        }
    }

    public void showRaceState() {
        OutputView.printRaceResult();

    }

    public void showEachCarState() {
        for (Car car : cars) {
            OutputView.printRaceResultEachCar(car.getName(), car.getMoveSign());
        }
    }
}
