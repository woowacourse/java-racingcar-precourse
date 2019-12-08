package ui;

import domain.RacingGameConfig;
import domain.Validator;
import domain.ValidatorImpl;
import domain.errors.InvalidInputException;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import util.RacingPrinter;
import util.RacingPrinterImpl;

import java.io.ByteArrayInputStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

//todo: mocking
class ConsoleTest {

    private Console console;
    private Scanner scanner;


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

        //when& then
        assertThrows(InvalidInputException.class, () -> console.extractNames());
    }
    @Test
    void extractRacingCarsWithNotAllowdCharacter() {
        //given
        String input = "pobi,crong,hon*ux";
        console = createConsoleForTest(input);

        //when & then
        assertThrows(InvalidInputException.class, () -> console.extractNames());

        //given
        input = "pobi, crong,honux";
        console = createConsoleForTest(input);

        //when & then
        assertThrows(InvalidInputException.class, () -> console.extractNames());
    }
    @Test
    void extractRacingCarsWithSeparatorAtLast() {
        //given
        String input = ",pobi,crong,honux,";
        console = createConsoleForTest(input);

        //when & then
        assertThrows(InvalidInputException.class, () -> console.extractNames());
    }


    @Test
    void getCyclesWitchValidInput() {
        String input = "1";
        console = createConsoleForTest(input);

        assertEquals(Integer.parseInt(input), console.getCycles());
    }
    @Test
    void getCyclesWitchInvalidInputs() {
        String input = String.valueOf(RacingGameConfig.MIN_CYCLES - 1) ;
        console = createConsoleForTest(input);
        assertThrows(InvalidInputException.class, () -> console.getCycles());

        input = "a";
        console = createConsoleForTest(input);
        assertThrows(InputMismatchException.class, () -> console.getCycles());

        input = "1.1";
        console = createConsoleForTest(input);
        assertThrows(InputMismatchException.class, () -> console.getCycles());
    }

    private Console createConsoleForTest(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        scanner = new Scanner(System.in);
        Validator validator = new ValidatorImpl();
        RacingPrinter racingPrinter = new RacingPrinterImpl();
        return new Console(scanner, validator, racingPrinter);
    }
}