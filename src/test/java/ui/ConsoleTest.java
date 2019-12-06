package ui;

import domain.Car;
import domain.RacingCar;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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
        List<RacingCar> result = new ArrayList<>(
                Arrays.asList(new Car("pobi"), new Car("crong"), new Car("honux"))
        );

        //when & then
        assertEquals(result, console.extractRacingCars());
    }

    private Console createConsoleForTest(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        scanner = new Scanner(System.in);
        return new Console(scanner);
    }
}