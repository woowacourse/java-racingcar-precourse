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

}