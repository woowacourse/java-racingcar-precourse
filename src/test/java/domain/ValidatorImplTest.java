package domain;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorImplTest {
    private ValidatorImpl validator;

    @BeforeEach
    void init() {
        validator = new ValidatorImpl();
    }

    @Test
    void validateNamesWithValidNames() {
        //given
        String[] names = {"pobi", "crong", "honux"};
        //when & then
        assertTrue(validator.validateNames(names));
    }
    @Test
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
    void validateNamesWithTooLongNames() {
        //given
        String tooLongName = StringUtils.repeat("a", RacingGameConfig.MAX_NAME_LENGTH + 1);
        String[] namesWithTooLongName = {tooLongName, "crong", "honux"};
        //when & then
        assertFalse(validator.validateNames(namesWithTooLongName));
    }
    @Test
    void validateNamesWithTooSmallNames() {
        //given
        String[] namesTooSmall = {"pobi"};
        //when & then
        assertFalse(validator.validateNames(namesTooSmall));
    }

    @Test
    void validateCyclesWithValidCycles() {
        //given
        int cycles = 5;
        //when & then
        assertTrue(validator.validateCycles(cycles));
    }
    @Test
    void validateCyclesWithTooSmallCycles() {
        //given
        int tooSmallCycles = RacingGameConfig.MIN_CYCLES - 1;

        //when & then
        assertFalse(validator.validateCycles(tooSmallCycles));
    }

}
