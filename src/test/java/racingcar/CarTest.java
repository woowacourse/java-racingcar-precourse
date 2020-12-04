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

    @Test
    @DisplayName("Car 객체 생성 시 보장된 이름이 들어간다")
    void testCarInitialize() {
        //given
        String nameHello = "Hello";
        String nameWorld = "World";

        //when
        Car car = new Car(nameHello);
        Car car2 = new Car(nameWorld);

        //then
        assertThat(car.getCarName()).isEqualTo(nameHello);
        assertThat(car2.getCarName()).isEqualTo(nameWorld);
    }

    @Test
    @DisplayName("Car 객체 생성 시 이름이 5글자 이상이면 에러가 발생한다.")
    void testCarInitializeLengthError() {
        //given
        String nameHello = "Hello!";
        String nameWorld = "World!";

        //then
        assertThatThrownBy(() -> new Car(nameHello))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름은 5자 이하만 입력 해주세요.");
        assertThatThrownBy(() -> new Car(nameWorld))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름은 5자 이하만 입력 해주세요.");
    }

    @Test
    @DisplayName("Car 객체 생성 시 이름에 숫자가 들어가면 에러가 발생한다.")
    void testCarInitializeNumberError() {
        //given
        String nameHi = "Hi12";
        String nameBye = "Bye34";

        //then
        assertThatThrownBy(() -> new Car(nameHi))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름에는 대,소문 영문자만 입력 해주세요.");
        assertThatThrownBy(() -> new Car(nameBye))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름에는 대,소문 영문자만 입력 해주세요.");
    }

    @Test
    @DisplayName("Car 객체 생성 시 이름에 특수문자가 들어가면 에러가 발생한다.")
    void testCarInitializeSpecialCharacterError() {
        //given
        String nameHi = "Hi!@#";
        String nameBye = "Bye$%";

        //then
        assertThatThrownBy(() -> new Car(nameHi))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름에는 대,소문 영문자만 입력 해주세요.");
        assertThatThrownBy(() -> new Car(nameBye))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름에는 대,소문 영문자만 입력 해주세요.");
    }

    @Test
    @DisplayName("Car 객체 생성 시 이름에 스페이스가 들어가면 에러가 발생한다.")
    void testCarInitializeSpaceError() {
        //given
        String nameHi = "H i";
        String nameBye = "B ye";

        //then
        assertThatThrownBy(() -> new Car(nameHi))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름에 스페이스바는 허용되지 않습니다.");
        assertThatThrownBy(() -> new Car(nameBye))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름에 스페이스바는 허용되지 않습니다.");
    }

    @Test
    @DisplayName("Car 객체 생성 시 이름에 한글이 들어가면 에러가 발생한다.")
    void testCarInitializeKoreanError() {
        //given
        String nameHi = "ㅎe";
        String nameBye = "바이";

        //then
        assertThatThrownBy(() -> new Car(nameHi))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름에는 대,소문 영문자만 입력 해주세요.");
        assertThatThrownBy(() -> new Car(nameBye))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름에는 대,소문 영문자만 입력 해주세요.");
    }
}
