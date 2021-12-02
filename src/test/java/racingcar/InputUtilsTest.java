package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;

import static constant.Constant.ERROR_CAR_NAME_LENGTH;
import static constant.Constant.ERROR_INVALID_ATTEMP;
import static org.assertj.core.api.Assertions.assertThat;

class InputUtilsTest {

    @DisplayName("5자 이상의 이름이 들어왔을 때 Test")
    @Test
    public void invalidCarNameInputTest() throws NoSuchMethodException {
        InputUtils inputUtils = new InputUtils();
        System.setIn(new ByteArrayInputStream("Audi,BMW,Ford,Ferrari".getBytes()));

        Method method = inputUtils.getClass().getDeclaredMethod("getCarList");
        method.setAccessible(true);

        try {
            method.invoke(inputUtils);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            assertThat(e.getCause().getMessage()).isEqualTo(ERROR_CAR_NAME_LENGTH);
        }
    }

    @DisplayName("시도 회수 입력이 숫자 아닌 경우 Test")
    @Test
    public void invalidAttempInput() throws NoSuchMethodException {
        InputUtils inputUtils = new InputUtils();

        Method method = inputUtils.getClass().getDeclaredMethod("checkInvalidAttempNum", String.class);
        method.setAccessible(true);

        try {
            method.invoke(inputUtils, "여섯");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            assertThat(e.getCause().getMessage()).isEqualTo(ERROR_INVALID_ATTEMP);
        }
    }

}