package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingRefereeImplTest {

    private RacingRefereeImpl racingReferee;

    @BeforeEach
    void init() {
        racingReferee = new RacingRefereeImpl();
    }

    @Test
    void distinguishWinnersWithNormalRacingCars() {
        racingReferee = new RacingRefereeImpl();
        Raceable pobi = new RacingCar(0,"pobi",3);
        Raceable crong = new RacingCar(1,"crong",2);
        Raceable honux = new RacingCar(2,"honux",3);
        List<Raceable> raceables = Arrays.asList(pobi, crong, honux);
        List<Raceable> winners = Arrays.asList(pobi, honux);

        assertEquals(winners, racingReferee.distinguishWinners(raceables));
    }
}