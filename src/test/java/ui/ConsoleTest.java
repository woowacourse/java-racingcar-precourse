package ui;

import domain.Car;
import domain.Raceable;
import domain.RacingCar;
import domain.errors.InvalidInputException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

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
    void extractRacingCarsWithValidInputs() {
        //given
        String input = "pobi,crong,honux";
        console = createConsoleForTest(input);
        List<Raceable> result = new ArrayList<>(
                Arrays.asList(new RacingCar("pobi"), new RacingCar("crong"), new RacingCar("honux"))
        );

        //when & then
        assertEquals(result, console.extractRacingCars());
    }

    @Test
    void getCyclesWitchValidInput() {
        String input = "1";
        console = createConsoleForTest(input);

        assertEquals(1, console.getCycles());
    }
    @Test
    void getCyclesWitchInvalidInputs() {
        String input = "-1";
        console = createConsoleForTest(input);

        assertThrows(InvalidInputException.class, () -> console.getCycles());

        input = "a";
        console = createConsoleForTest(input);
        assertThrows(InputMismatchException.class, () -> console.getCycles());

    }

    private Console createConsoleForTest(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        scanner = new Scanner(System.in);
        return new Console(scanner);
    }
}