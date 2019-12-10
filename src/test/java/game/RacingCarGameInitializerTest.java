package game;

import domain.Car;
import domain.TrialTimes;
import exception.InvalidInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RacingCarGameInitializerTest {

    private static final String CAR_NAMES_DELIMITER = ",";
    private static final String VALID_NAMES_STRING = "jaeju,david,luke,peter";
    private static final int VALID_NAMES_SIZE = VALID_NAMES_STRING.split(CAR_NAMES_DELIMITER).length;
    private static final String INVALID_CAR_NAME_SIZE_STRING = "jaeju";
    private static final String INVALID_CAR_NAME_DUPLICATION_STRING = "jaeju,david,jaeju";
    private static final String VALID_TRIAL_TIMES_STRING = "1";
    private static final int VALID_TRIAL_TIMES_INTEGER = Integer.parseInt(VALID_TRIAL_TIMES_STRING);
    private static final String INVALID_TRIAL_TIMES_STRING = "0";

    private RacingCarGameInitializer racingCarGameInitializer;

    @BeforeEach
    void setUp() {
        racingCarGameInitializer = new RacingCarGameInitializer();
    }

    @Test
    void makeCarListTest_ValidInput_ValidOutout() {
        List<Car> cars = racingCarGameInitializer.makeCarList(VALID_NAMES_STRING);
        assertEquals(cars.size(), VALID_NAMES_SIZE);
    }

    @Test
    void makeCarListTest_SizeException() {
        assertThrows(InvalidInputException.class, () -> racingCarGameInitializer.makeCarList(INVALID_CAR_NAME_SIZE_STRING));
    }

    @Test
    void makeCarListTest_DuplicationException() {
        assertThrows(InvalidInputException.class, () -> racingCarGameInitializer.makeCarList(INVALID_CAR_NAME_DUPLICATION_STRING));
    }

    @Test
    void makeTrialTimesTest_ValidInput_ValidOutput() {
        TrialTimes trialTimes = racingCarGameInitializer.makeTrialTimes(VALID_TRIAL_TIMES_STRING);
        assertEquals(trialTimes.getTrialTimes(), VALID_TRIAL_TIMES_INTEGER);
    }

    @Test
    void makeTrialTimesTest_BelowOne_Exception() {
        assertThrows(InvalidInputException.class, () -> racingCarGameInitializer.makeTrialTimes(INVALID_TRIAL_TIMES_STRING));
    }
}
