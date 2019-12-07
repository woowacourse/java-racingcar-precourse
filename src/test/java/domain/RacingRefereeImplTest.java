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
        RacingCar pobi = new Car(0,"pobi",3);
        RacingCar crong = new Car(1,"crong",2);
        RacingCar honux = new Car(2,"honux",3);
        List<RacingCar> racingCars = Arrays.asList(pobi, crong, honux);
        List<RacingCar> winners = Arrays.asList(pobi, honux);

        assertEquals(winners, racingReferee.distinguishWinners(racingCars));
    }
}