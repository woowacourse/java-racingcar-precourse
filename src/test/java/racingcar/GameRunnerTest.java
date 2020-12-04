package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import exception.CarNameOverFiveException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameRunnerTest {

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

}
