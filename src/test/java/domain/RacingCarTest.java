package domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingCarTest {

    private Random mockRandomGenerator = mock(Random.class);
    private RacingCar racingCar;

    @BeforeEach
    void init() {
        racingCar = new RacingCar("testRacingCar", mockRandomGenerator);
    }

    @Test
    void raceWhenCanGo() {
        //given
        int defaultPosition = racingCar.getPosition();
        when(mockRandomGenerator.nextInt(anyInt())).thenReturn(RacingGameConfig.STANDARD_TO_GO);
        //when
        racingCar.race();
        //then
        assertEquals(defaultPosition + RacingGameConfig.STEP, racingCar.getPosition());
    }

    @Test
    void raceWhenCanNotGo() {
        //given
        int defaultPosition = racingCar.getPosition();
        when(mockRandomGenerator.nextInt(anyInt())).thenReturn(RacingGameConfig.STANDARD_TO_GO - 1);
        //when
        racingCar.race();
        //then
        assertEquals(defaultPosition, racingCar.getPosition());
    }
}