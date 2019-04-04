import domain.Car;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RacingTrialTest {
    private final int N_CARS = 50000;

    private RacingTrial racingTrial;

    @Before
    public void setUp() throws Exception {
        this.racingTrial = new RacingTrial();
    }

    @Test
    public void doTrialAllTryMove() {
        List<Car> mockedCars = new ArrayList();
        IntStream.range(0, N_CARS).forEach((i) -> {
            Car mockCar = mock(Car.class);

            mockedCars.add(mockCar);
        });
        ScoreBoard mockedScoreBoard = mock(ScoreBoard.class);


        // Act
        this.racingTrial.doTrial(mockedCars, mockedScoreBoard);

        // Assert
        for (Car mockedCar : mockedCars) {
            verify(mockedCar).tryMove();
        }
    }

    @Test
    public void doTrialPrintAfterTryMove() {
        List<Car> mockedCars = new ArrayList();
        IntStream.range(0, N_CARS).forEach((i) -> {
            Car mockCar = mock(Car.class);

            mockedCars.add(mockCar);
        });
        ScoreBoard mockedScoreBoard = mock(ScoreBoard.class);


        // Act
        this.racingTrial.doTrial(mockedCars, mockedScoreBoard);

        // Assert

        for (Car mockedCar : mockedCars) {
            InOrder inOrder = inOrder(mockedCar, mockedScoreBoard);

            inOrder.verify(mockedCar).tryMove();
            inOrder.verify(mockedScoreBoard).Print(mockedCars);
        }
    }
}