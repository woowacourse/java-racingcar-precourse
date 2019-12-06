package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacingRefereeImplTest {

    private RacingRefereeImpl racingReferee;

    @Test
    void updateMaxPositionWhenPositionIsBiggerThanMaxPosition() {
        //given
        racingReferee = new RacingRefereeImpl(0);
        int position = 3;

        //when
        racingReferee.updateMaxPosition(position);

        //then
        assertEquals(new RacingRefereeImpl(position), racingReferee);
    }
    @Test
    void updateMaxPositionWhenPositionIsSmallerThanMaxPosition() {
        //given
        int maxPosition = 3;
        racingReferee = new RacingRefereeImpl(maxPosition);
        int position = 1;

        //when
        racingReferee.updateMaxPosition(position);

        //then
        assertNotEquals(new RacingRefereeImpl(position), racingReferee);
        assertEquals(new RacingRefereeImpl(maxPosition), racingReferee);
    }
}