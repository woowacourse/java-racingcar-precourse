package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingRefereeImplTest {

    private RacingRefereeImpl racingReferee;

    @BeforeEach
    void init() {
        racingReferee = new RacingRefereeImpl();
    }

    @Test
    void distinguishWinnersWithNormalRacingCars() {
        racingReferee = new RacingRefereeImpl();
        Raceable pobi = new RacingCar("pobi", 3);
        Raceable crong = new RacingCar("crong", 2);
        Raceable honux = new RacingCar("honux", 3);
        List<Raceable> raceables = Arrays.asList(pobi, crong, honux);
        List<Raceable> winners = Arrays.asList(pobi, honux);

        assertEquals(winners, racingReferee.distinguishWinners(raceables));
    }
}