package util;

import domain.Car;
import domain.RacingCar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
    void printRacingCar() {
        //given
        RacingCar racingCar = new Car(0, "testCar", 4);

        //when
        racingPrinter.printRacingCar(racingCar);

        //then
        assertEquals("testCar : ----\n", outView.toString());
    }
}