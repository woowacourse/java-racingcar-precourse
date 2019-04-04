package domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CarTest {

    @Test
    public void tryMoveValidV() {
        IntStream validRandValues = IntStream.of(4, 5, 6, 7, 8, 9);

        validRandValues.forEach((v) -> {
            Random mockedRand = mock(Random.class);
            when(mockedRand.nextInt(Car.MAX_RAND)).thenReturn(v);
            Car car = new Car("", mockedRand);
            int wantPosition = car.getPosition() + 1;

            // Act
            car.tryMove();


            // Assert
            Assert.assertEquals(wantPosition, car.getPosition());
        });
    }

    @Test
    public void tryMoveInvalidV() {
        IntStream validRandValues = IntStream.of(0, 1, 2, 3);

        validRandValues.forEach((v) -> {
            Random mockedRand = mock(Random.class);
            when(mockedRand.nextInt(Car.MAX_RAND)).thenReturn(v);
            Car car = new Car("", mockedRand);
            int wantPosition = car.getPosition();

            // Act
            car.tryMove();


            // Assert
            Assert.assertEquals(wantPosition, car.getPosition());
        });
    }
}