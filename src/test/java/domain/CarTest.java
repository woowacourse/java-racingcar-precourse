package domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {

    @Test
    public void testFailToForwardCarIfRandomNumBelowMeanOfUpperBoundAndLowerBound() throws AssertionError {
        Car car = Car.createCarWithName("car1");
        int mean = (RandomNumGenerator.RandomNumBound.UPPER.getBound()
                + RandomNumGenerator.RandomNumBound.LOWER.getBound()) / 2;

        car.ForwardOrStop(mean - 1);

        assertFalse(car.doesCarMoved());
    }

    @Test
    public void testFailToStopCarIfRandomNumAboveMeanOfUpperBoundAndLowerBound() throws AssertionError {
        Car car = Car.createCarWithName("car1");
        int mean = (RandomNumGenerator.RandomNumBound.UPPER.getBound()
                + RandomNumGenerator.RandomNumBound.LOWER.getBound()) / 2;

        car.ForwardOrStop(mean);

        assertTrue(car.doesCarMoved());
    }
}