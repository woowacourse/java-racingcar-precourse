package racingcar;

import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.engine.DefaultEngine;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

class CarTest {

    @RepeatedTest(10)
    @Description("Car의 현재 위치 출력 값을 확인하는 테스트")
    public void getCurrentPositionTest() {

        //given
        String name = "자동차씨";
        Car car = Car.create(name, new DefaultEngine());

        //when
        car.move();
        String currentPosition = car.getCurrentPosition();

        //then
        // 예시 : woni : ----
        // 정규표현식 : [\\S]{1,5} : [-]{0,}
        boolean result = Pattern.matches("[\\S]{1,5} : [-]{0,}", currentPosition);
        Assertions.assertTrue(result);

    }

    @Test
    @Description("Car A의 position이 B보다 높거나 같은 경우, true를 반환")
    public void atFirstPositionTest() throws NoSuchFieldException, IllegalAccessException {

        //given
        Car A = Car.create("A", new DefaultEngine());
        Car B = Car.create("B", new DefaultEngine());  //position = 0
        Car C = Car.create("C", new DefaultEngine());  //position = 0

        //when
        Field position = Car.class.getDeclaredField("position");
        position.setAccessible(true);
        position.set(A, 10);              //position = 1;

        //then
        Assertions.assertFalse(A.atFirstPosition(B));
        Assertions.assertFalse(B.atFirstPosition(A));
        Assertions.assertTrue(B.atFirstPosition(C));

    }

}