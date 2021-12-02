package racingcar.race;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RaceControllerTest {

    public RaceController raceController = RaceController.getInstance();

    @Test
    public void 자동차_이름_검증_테스트() {
        String[] properInput = {"pobi", "woni", "jun"};
        String[] improperInput = {"pobi", "woni", "nayoung", "jun"};

        assertTrue(raceController.isSatisfyAllCarName(properInput));
        assertFalse(raceController.isSatisfyAllCarName(improperInput));
    }
}