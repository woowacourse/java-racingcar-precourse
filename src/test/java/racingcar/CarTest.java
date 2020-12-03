package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.InputUtils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    public static InputUtils getInputUtils(String inputText) {
        InputStream inputStream = new ByteArrayInputStream(inputText.getBytes());
        System.setIn(inputStream);
        Scanner scanner = new Scanner(inputStream);
        InputUtils inputUtils = InputUtils.of(scanner);
        return inputUtils;
    }

    @Test
    @DisplayName("분리한 이름 Car 객체 할당 확인")
    void testCar() {
        //given
        String inputText = "live,now,here";
        InputUtils inputUtils = getInputUtils(inputText);
        List<Car> cars = new ArrayList<>();

        //when
        String[] carNames = inputUtils.inputAndGetCarNames();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        //then
        assertThat(cars.get(0).getCarName()).isEqualTo("live");
        assertThat(cars.get(1).getCarName()).isEqualTo("now");
        assertThat(cars.get(2).getCarName()).isEqualTo("here");
    }
}