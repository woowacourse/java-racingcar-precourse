package racingcar;

import domain.Car;

import java.util.List;

//테스트를 위한 레이스 (자리 증가분은 모두 동일하게 1 씩 증가)
public class TestRace extends Race {
    private static final int MIN_RUNNABLE = 4;

    public TestRace(List<Car> cars, int round) {
        super(cars, round);
    }

    @Override
    protected void makeCarRun() {
        cars.forEach(car -> car.run(MIN_RUNNABLE));
    }
}
