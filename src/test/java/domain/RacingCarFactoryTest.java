package domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarFactoryTest {

    private Validator mockValidator = mock(Validator.class);
    private RacingCarFactory racingCarFactory;

    @BeforeEach
    void init() {
        racingCarFactory = new RacingCarFactory(mockValidator);
    }

    @Test
    @DisplayName("#create: return racingCars")
    void createWithValidNames() {
        //given
        String[] names = {"pobi", "crong", "honux"};
        List<Raceable> result = Arrays.asList(
                new RacingCar("pobi"), new RacingCar("crong"), new RacingCar("honux")
        );
        when(mockValidator.validateNames(names)).thenReturn(true);

        //when & then
        assertEquals(result, racingCarFactory.create(names));
    }

    @Test
    @DisplayName("#create: throw InvaldParameterException")
    void createWithInvalidNames() {
        //given
        String[] namesWithSpace = {"pobi ", "crong", "honux"};
        when(mockValidator.validateNames(namesWithSpace)).thenReturn(false);
        //when & then
        assertThrows(InvalidParameterException.class, () -> racingCarFactory.create(namesWithSpace));

        //given
        String nameWithSpecialSymbol = "po*bi";
        String[] namesWithSpecialSymbol = {nameWithSpecialSymbol, "crong", "honux"};
        when(mockValidator.validateNames(namesWithSpecialSymbol)).thenReturn(false);
        //when & then
        assertThrows(InvalidParameterException.class, () -> racingCarFactory.create(namesWithSpecialSymbol));

        //given
        String tooLongName = StringUtils.repeat("a", RacingGameConfig.MAX_NAME_LENGTH + 1);
        String[] namesWithTooLongName = {tooLongName, "crong", "honux"};
        when(mockValidator.validateNames(namesWithTooLongName)).thenReturn(false);
        //when & then
        assertThrows(InvalidParameterException.class, () -> racingCarFactory.create(namesWithTooLongName));
    }
}