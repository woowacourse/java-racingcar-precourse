package ui;

import domain.Validator;
import domain.ValidatorImpl;
import domain.errors.InvalidInputException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleTest {

    private Console console;
    private Scanner scanner;
    private Validator validator;

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
    void extractRacingCarsWithValidInputs() {
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
    void extractRacingCarsWithoutSeparator() {
        //given
        String input = "pobi crong honux";
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
        String input = "-1";
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
        return new Console(scanner, validator);
    }
}