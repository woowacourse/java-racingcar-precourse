package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.setDescriptionConsumer;
import static org.junit.jupiter.api.Assertions.*;

import exception.CarNameOverFiveException;
import exception.MoveCountNotIntegerException;
import exception.MoveCountNotOverZeroException;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameRunnerTest {

    private final int RANDOM_METHOD_CHECK_COUNT = 1000;
    private final int RANDOM_MIN = 0;
    private final int RANDOM_MAX = 9;

    @Test
    public void Should_Parse_Three_Name_When_Three_Serial_String_Input() {
        List<Car> testCarList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Car car = new Car(Integer.toString(i));
            testCarList.add(car);
        }

        GameRunner gameRunner = new GameRunner();
        gameRunner.parseCarInput("0,1,2");
        List<Car> carList = gameRunner.getCarList();

        boolean checkEqualList = true;

        if (carList.size() != testCarList.size()) {
            checkEqualList = false;
        }

        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getName().compareTo(testCarList.get(i).getName()) != 0) {
                checkEqualList = false;
                break;
            }
        }

        assertThat(checkEqualList).isEqualTo(true);
    }

    @Test
    public void Should_Return_True_When_Below_Name_Length_Limit() {
        GameRunner gameRunner = new GameRunner();
        boolean nameLengthCheck = gameRunner.checkCarNameLengthLimit("12345");
        assertThat(nameLengthCheck).isEqualTo(true);
    }

    @Test
    public void Should_ThrownException_When_Over_Name_Length_Limit() {
        GameRunner gameRunner = new GameRunner();
        Assertions.assertThrows(CarNameOverFiveException.class,
            () -> gameRunner.checkCarNameLengthLimit("123456"));
    }

    @Test
    public void Should_ThrownException_When_Move_Count_Not_Integer() {
        String data = "Yes";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);

        GameRunner gameRunner = new GameRunner();
        Assertions.assertThrows(MoveCountNotIntegerException.class,
            () -> gameRunner.getMoveCount(scanner));
    }

    @Test
    public void Should_ThrownException_When_Move_Count_Not_Over_Zero() {
        String data = "0";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);

        GameRunner gameRunner = new GameRunner();
        Assertions.assertThrows(MoveCountNotOverZeroException.class,
            () -> gameRunner.getMoveCount(scanner));
    }

    @Test
    public void Should_Random_Number_On_Domain() {
        boolean randomNumberCheck = true;
        for (int i = 0; i < RANDOM_METHOD_CHECK_COUNT; i++) {
            GameRunner gameRunner = new GameRunner();
            int randomNumber = gameRunner.getRandomNumber();
            if (randomNumber < RANDOM_MIN || randomNumber > RANDOM_MAX) {
                randomNumberCheck = false;
                break;
            }
        }
        assertThat(randomNumberCheck).isEqualTo(true);
    }
}
