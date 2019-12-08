package ui;

import domain.RacingGameConfig;
import domain.Validator;
import domain.errors.InvalidInputException;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import util.RacingPrinter;

import java.io.ByteArrayInputStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ConsoleTest {

    private Console console;
    private Scanner scanner;
    private Validator mockValidator = mock(Validator.class);
    private RacingPrinter mockRacingPrinter = mock(RacingPrinter.class);

    @AfterEach
    void clear() {
        try {
            scanner.close();
        } catch (RuntimeException e) {
            System.out.println(String.format("테스트 중 다음과 같은 오류로 시스템을 종료합니다 : %s", e.getMessage()));
            System.exit(-1);
        }
    }

    @Test
    void extractNamesWithValidInputs() {
        //given
        String input = "pobi,crong,honux";
        console = createConsoleForTest(input);
        String[] result = {"pobi", "crong", "honux"};
        when(mockValidator.validateNames(any())).thenReturn(true);
        //when & then
        assertArrayEquals(result, console.extractNames());

        //given
        input = " pobi,crong,honux ";
        console = createConsoleForTest(input);
        //when & then
        assertArrayEquals(result, console.extractNames());
    }
    @Test
    void extractNamesWithTooLongNames() {
        //given
        String tooLongName = StringUtils.repeat("a", RacingGameConfig.MAX_NAME_LENGTH + 1);
        String input = String.format("%s,crong,honux", tooLongName);
        console = createConsoleForTest(input);
        when(mockValidator.validateNames(any())).thenReturn(false);
        //when& then
        assertThrows(InvalidInputException.class, () -> console.extractNames());
    }
    @Test
    void extractNamesWithNotAllowdCharacter() {
        //given
        String input = "pobi,crong,hon*ux";
        console = createConsoleForTest(input);
        when(mockValidator.validateNames(any())).thenReturn(false);
        //when & then
        assertThrows(InvalidInputException.class, () -> console.extractNames());

        //given
        input = "pobi, crong,honux";
        console = createConsoleForTest(input);
        //when & then
        assertThrows(InvalidInputException.class, () -> console.extractNames());
    }
    @Test
    void extractNamesWithSeparatorAtLast() {
        //given
        String input = ",pobi,crong,honux,";
        console = createConsoleForTest(input);
        //when & then
        assertThrows(InvalidInputException.class, () -> console.extractNames());
    }


    @Test
    void getCyclesWitchValidInput() {
        //given
        String input = "1";
        console = createConsoleForTest(input);
        when(mockValidator.validateCycles(anyInt())).thenReturn(true);
        //when & then
        assertEquals(Integer.parseInt(input), console.getCycles());
    }
    @Test
    void getCyclesWitchInvalidInputs() {
        //given
        String input = String.valueOf(RacingGameConfig.MIN_CYCLES - 1) ;
        console = createConsoleForTest(input);
        when(mockValidator.validateCycles(anyInt())).thenReturn(false);
        //when & then
        assertThrows(InvalidInputException.class, () -> console.getCycles());

        //given
        input = "a";
        console = createConsoleForTest(input);
        //when & then
        assertThrows(InputMismatchException.class, () -> console.getCycles());

        //given
        input = "1.1";
        console = createConsoleForTest(input);
        //when & then
        assertThrows(InputMismatchException.class, () -> console.getCycles());
    }

    private Console createConsoleForTest(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        scanner = new Scanner(System.in);

        return new Console(scanner, mockValidator, mockRacingPrinter);
    }
}