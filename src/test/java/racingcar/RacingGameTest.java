package racingcar;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import racingcar.domain.Car;
import racingcar.utils.CarListGenerator;

public class RacingGameTest {
    private RacingCars carCollection;

    @Before
    public void setup() {
        carCollection = new RacingCars(CarListGenerator.generate("crong,pobi,jun"));
    }

    @Test
    public void 복수_우승자() {
        for(Car car : carCollection.getCars())
            car.increasePosition();

        Assert.assertEquals(3, carCollection.getWinners().size());
    }
}
