package util;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.Raceable;
import domain.RacingCar;

class RacingPrinterImplTest {

    private RacingPrinterImpl racingPrinter;
    private final ByteArrayOutputStream outView = new ByteArrayOutputStream();

    @BeforeEach
    void init() {
        racingPrinter = new RacingPrinterImpl();
        System.setOut(new PrintStream(outView));
    }

    @Test
    void printStartGameSign() {
        racingPrinter.printStartGameSign();
        assertEquals("\n실행 결과\n", outView.toString());
    }

    @Test
    void printStateOfRacingCar() {
        //given
        int amountToGo = 4;
        RacingCar racingCar = new RacingCar("testCar", amountToGo);

        //when
        racingPrinter.printStateOfRacingCar(racingCar);

        //then
        assertEquals(String.format("testCar : %s\n", StringUtils.repeat("-", amountToGo)), outView.toString());
    }

    @Test
    void printWinners() {
        //given
        List<Raceable> winners = Arrays.asList(
                new RacingCar("poby"),
                new RacingCar("honux")
        );

        //when
        racingPrinter.printWinners(winners);

        //then
        assertEquals("poby, honux가 최종 우승했습니다.\n", outView.toString());
    }


    @Test
    void printOneCycleFinished() {
        racingPrinter.printOneCycleFinished();
        assertEquals("\n", outView.toString());
    }

    @Test
    void printRequestForNames() {
        racingPrinter.printRequestForNames();
        assertEquals("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n", outView.toString());
    }

    @Test
    void printRequestForCycles() {
        racingPrinter.printRequestForCycles();
        assertEquals("시도할 회수는 몇회인가요?\n", outView.toString());
    }
}