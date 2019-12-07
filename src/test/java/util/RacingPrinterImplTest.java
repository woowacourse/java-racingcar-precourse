package util;

import domain.Car;
import domain.RacingCar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingPrinterImplTest {

    private RacingPrinterImpl racingPrinter;
    private final ByteArrayOutputStream outView = new ByteArrayOutputStream();

    @BeforeEach
    void init() {
        racingPrinter = new RacingPrinterImpl();
        System.setOut(new PrintStream(outView));
    }

    @Test
    void printStateOfRacingCar() {
        //given
        RacingCar racingCar = new Car(0, "testCar", 4);

        //when
        racingPrinter.printStateOfRacingCar(racingCar);

        //then
        assertEquals("testCar : ----\n", outView.toString());
    }

    @Test
    void printWinners() {
        //given
        List<RacingCar> winners = Arrays.asList(
                new Car(1, "poby", 4),
                new Car(3, "honux", 4)
        );

        //when
        racingPrinter.printWinners(winners);

        //then
        assertEquals("poby, honux가 최종 우승했습니다.\n", outView.toString());
    }
}