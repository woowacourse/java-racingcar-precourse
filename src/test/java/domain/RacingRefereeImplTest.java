package domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingRefereeImplTest {

    private RacingRefereeImpl racingReferee;
    private List<Raceable> raceables;
    private Validator validator = mock(Validator.class);

    @BeforeEach
    void init() {
        racingReferee = new RacingRefereeImpl(validator);
    }

    @Test
    @DisplayName("#distinguisWinners: return winners")
    void distinguishWinnersWithNormalRacingCars() {
        Raceable pobi = new RacingCar("pobi", 3);
        Raceable crong = new RacingCar("crong", 2);
        Raceable honux = new RacingCar("honux", 3);
        raceables = Arrays.asList(pobi, crong, honux);
        when(validator.validateRaceables(raceables)).thenReturn(true);
        List<Raceable> winners = Arrays.asList(pobi, honux);

        assertEquals(winners, racingReferee.distinguishWinners(raceables));
    }
    @Test
    @DisplayName("#distinguisWinners: throw IllegalArgumentException with invalid raceables")
    void distinguishWinnersWithInvalidRaceables() {
        raceables = new ArrayList<>();
        when(validator.validateRaceables(raceables)).thenReturn(false);
        assertThrows(IllegalArgumentException.class, () -> racingReferee.distinguishWinners(raceables));

        raceables = null;
        when(validator.validateRaceables(raceables)).thenReturn(false);
        assertThrows(IllegalArgumentException.class, () -> racingReferee.distinguishWinners(raceables));
    }

}