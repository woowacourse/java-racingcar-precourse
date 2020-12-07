package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RacingGameTest {
    private RacingGame racingGame;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    public void setup(){
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testSetupSuccess() throws NoSuchMethodException, NoSuchFieldException, InvocationTargetException, IllegalAccessException {
        //given
        String carData = "aaa,bbb,ccc";
        System.setIn(new ByteArrayInputStream(carData.getBytes()));
        racingGame = new RacingGame(new Scanner(System.in));
        Method setupMethod = racingGame.getClass().getDeclaredMethod("setup");
        setupMethod.setAccessible(true);
        Field carListField = racingGame.getClass().getDeclaredField("carList");
        carListField.setAccessible(true);
        //when
        setupMethod.invoke(racingGame);
        //then
        assertThat(((List<Car>)carListField.get(racingGame)).get(0).getName()).isEqualTo("aaa");
        assertThat(((List<Car>)carListField.get(racingGame)).get(1).getName()).isEqualTo("bbb");
        assertThat(((List<Car>)carListField.get(racingGame)).get(2).getName()).isEqualTo("ccc");
    }

    @Test
    public void testSetupCarsFailsWithLongerName() throws NoSuchMethodException, NoSuchFieldException, InvocationTargetException, IllegalAccessException {
        //given
        String carData = "aaaaaaa,bbb,ccc";
        racingGame = new RacingGame(new Scanner(System.in));
        Method setupCarsMethod = racingGame.getClass().getDeclaredMethod("setupCars", String.class);
        setupCarsMethod.setAccessible(true);
        //when
        //then
        assertThrows(Exception.class, ()->
                setupCarsMethod.invoke(racingGame, carData));
    }
}