package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    public void isAppropriateName(){
        String input = "abcde";
        Car car = new Car(input);

        assertThat("abcde").isEqualTo(car.getName());

    }

    @Test
    public void isUnappropriatedName(){
        String input = "abcdef";
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> new Car(input));

        assertThat("[ERROR] 5자 이하의 이름을 입력하세요.").isEqualTo(thrown.getMessage());
    }

    @Test
    public void go(){
        int number = 4;
        Car car = new Car("test");
        car.goOrStop(4);

        assertThat(1).isEqualTo(car.getPosition());
    }

    @Test
    public void stop(){
        int number = 3;
        Car car = new Car("test");
        car.goOrStop(number);

        assertThat(0).isEqualTo(car.getPosition());
    }

}