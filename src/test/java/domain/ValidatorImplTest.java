package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ValidatorImplTest {
    private ValidatorImpl validator;

    @BeforeEach
    void init() {
        validator = new ValidatorImpl();
    }

    @Test
    @DisplayName("#validateNames: return true")
    void validateNamesWithValidNames() {
        //given
        String[] names = {"pobi", "crong", "honux"};
        //when & then
        assertTrue(validator.validateNames(names));
    }

    @Test
    @DisplayName("#validateNames: return false with not allowed characters")
    void validateNamesWithNotAllowdCharacter() {
        //given
        String[] namesWithSpace = {"pobi ", "crong", "honux"};
        //when & then
        assertFalse(validator.validateNames(namesWithSpace));

        //given
        String[] namesWithSpecialSymbol = {"pobi*", "crong", "honux"};
        //when & then
        assertFalse(validator.validateNames(namesWithSpecialSymbol));
    }

    @Test
    @DisplayName("#validateNames: return false with not too long names")
    void validateNamesWithTooLongNames() {
        //given
        String tooLongName = StringUtils.repeat("a", RacingGameConfig.MAX_NAME_LENGTH + 1);
        String[] namesWithTooLongName = {tooLongName, "crong", "honux"};
        //when & then
        assertFalse(validator.validateNames(namesWithTooLongName));
    }

    @Test
    @DisplayName("#validateNames: return false with not too small names")
    void validateNamesWithTooSmallNames() {
        //given
        String[] namesTooSmall = {"pobi"};
        //when & then
        assertFalse(validator.validateNames(namesTooSmall));
    }

    @Test
    @DisplayName("#validateCycles: return true")
    void validateCyclesWithValidCycles() {
        //given
        int cycles = 5;
        //when & then
        assertTrue(validator.validateCycles(cycles));
    }

    @Test
    @DisplayName("#validateCycles: return false with too small cycles")
    void validateCyclesWithTooSmallCycles() {
        //given
        int tooSmallCycles = RacingGameConfig.MIN_CYCLES - 1;
        //when & then
        assertFalse(validator.validateCycles(tooSmallCycles));
    }

    @Test
    @DisplayName("#validateRaceables: return true with valid raceables")
    void validateRaceablesWithValidRaceables() {
        //given
        List<Raceable> raceables = Arrays.asList(new RacingCar("pobi"), new RacingCar("crong"));

        //then
        assertTrue(validator.validateRaceables(raceables));
    }

    @Test
    @DisplayName("#validateRaceables: return falce with invalid raceables")
    void validateRaceablesWithInvalidRaceables() {
        assertFalse(validator.validateRaceables(null));
        assertFalse(validator.validateRaceables(new ArrayList<>()));
    }
}
