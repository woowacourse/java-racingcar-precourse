package racingcar.domain.engine;

import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.setting.CarSetting;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class EngineTest {

    @RepeatedTest(100)
    @Description("0~9까지 난수 생성")
    public void getRandomNumberTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        //given
        Engine engine = new DefaultEngine();

        //when
        Method method = DefaultEngine.class.getDeclaredMethod("getRandomNumber");
        method.setAccessible(true);
        int result = (int) method.invoke(engine);

        //then
        assertTrue(result >= 0 && result < 10);

    }


    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    @Description("숫자가 4이상이면 true, 4미만이면 false를 반환")
    public void canMoveTest(int number) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        //given
        Engine engine = new DefaultEngine();

        //when
        Method canMove = DefaultEngine.class.getDeclaredMethod("canMove", int.class);
        canMove.setAccessible(true);

        boolean result = (boolean) canMove.invoke(engine, number);

        //then
        Assertions.assertEquals(number >= CarSetting.REQUIRE_POWER.get(), result);

    }

    @RepeatedTest(100)
    @Description("1 혹은 0을 반환")
    public void engineTest() {

        //given
        Engine engine = new DefaultEngine();

        //when
        int result = engine.getPower();

        //then
        assertTrue(result == CarSetting.MOVE.get()
                || result == CarSetting.STAY.get());

    }

}