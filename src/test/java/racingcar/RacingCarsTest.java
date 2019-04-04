package racingcar;

import org.junit.Test;
import racingcar.utils.CarListGenerator;

public class RacingCarsTest {

    @Test(expected = IllegalArgumentException.class)
    public void 블랭크_입력() {
        new RacingCars(CarListGenerator.generate("crong,,jun"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 이름_5자초과_입력() {
        new RacingCars(CarListGenerator.generate("crong,crong5,jun"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 차이름_하나_입력() {
        new RacingCars(CarListGenerator.generate("jun"));
    }
}
