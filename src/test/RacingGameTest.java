import domain.Car;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RacingGameTest {

    private final int N_CARS = 3;
    private final int N_TRIALS = 5;

    private RacingGame game;
    private List<Car> mockedCars;

    @Before
    public void setUp() throws Exception {
        mockedCars = new ArrayList();
        IntStream.range(0, N_CARS).forEach((i) -> {
            Car mockCar = mock(Car.class);

            mockedCars.add(mockCar);
        });

        game = new RacingGame(mockedCars, N_TRIALS);
    }

    @Test
    public void playWithN_Trials() {
        RacingTrial mockedRacingTrial = mock(RacingTrial.class);
        ScoreBoard mockedScoreBoard = mock(ScoreBoard.class);


        // Act
        game.play(mockedRacingTrial, mockedScoreBoard);


        // Assert
        verify(mockedRacingTrial, times(N_TRIALS)).doTrial(mockedCars, mockedScoreBoard);
    }
}