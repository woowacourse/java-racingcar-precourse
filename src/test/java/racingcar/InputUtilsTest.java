package racingcar;

import Utils.InputUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static constant.Constant.*;
import static org.assertj.core.api.Assertions.assertThat;

class InputUtilsTest {
    InputUtils inputUtils = new InputUtils();

    @DisplayName("[자동차 이름] 정상 구동이 되는지")
    @Test
    public void returnCarListTest() {
        System.setIn(new ByteArrayInputStream("Audi,BMW,Ford,Benz".getBytes()));

        String[] answerArr = {"Audi", "BMW", "Ford", "Benz"};
        List<Car> carList = inputUtils.returnCarList();

        String[] resultArr = new String[carList.size()];
        for (int i = 0; i < carList.size(); i++) {
            resultArr[i] = carList.get(i).getName();
        }

        assertThat(answerArr).isEqualTo(resultArr);
    }

    @DisplayName("[시도 회수] 정상 구동이 되는지")
    @Test
    public void getAttempNumTest() {
        System.setIn(new ByteArrayInputStream("123".getBytes()));

        int answer = 123;
        int result = inputUtils.getAttempNum();

        assertThat(answer).isEqualTo(result);
    }

    @DisplayName("[자동차 이름] 입력값이 쉽표로 시작하는 경우")
    @Test
    public void checkInvalidCarNameInputTest1() throws NoSuchMethodException {
        Method method = inputUtils.getClass().getDeclaredMethod("checkInvalidCarNameInput", String.class);
        method.setAccessible(true);

        try {
            method.invoke(inputUtils, ",mike,james");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            assertThat(e.getCause().getMessage()).isEqualTo(ERROR_CAR_NAME_INPUT_ETC);
        }
    }

    @DisplayName("[자동차 이름] 입력값이 쉽표로 끝나는 경우")
    @Test
    public void checkInvalidCarNameInputTest2() throws NoSuchMethodException {
        Method method = inputUtils.getClass().getDeclaredMethod("checkInvalidCarNameInput", String.class);
        method.setAccessible(true);

        try {
            method.invoke(inputUtils, "mike,james,");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            assertThat(e.getCause().getMessage()).isEqualTo(ERROR_CAR_NAME_INPUT_ETC);
        }
    }

    @DisplayName("[자동차 이름] 쉽표가 두개 붙어있는 입력값인 경우")
    @Test
    public void checkInvalidCarNameInputTest3() throws NoSuchMethodException {
        Method method = inputUtils.getClass().getDeclaredMethod("checkInvalidCarNameInput", String.class);
        method.setAccessible(true);

        try {
            method.invoke(inputUtils, "mike,/james");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            assertThat(e.getCause().getMessage()).isEqualTo(ERROR_CAR_NAME_INPUT_ETC);
        }
    }

    @DisplayName("[자동차 이름] 5자리 이상의 이름인 경우")
    @Test
    public void checkCarNameLengthTest() throws NoSuchMethodException {
        Method method = inputUtils.getClass().getDeclaredMethod("checkCarNameLength", String.class);
        method.setAccessible(true);

        try {
            method.invoke(inputUtils, "christopher");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            assertThat(e.getCause().getMessage()).isEqualTo(ERROR_CAR_NAME_LENGTH);
        }
    }

    @DisplayName("[자동차 이름, 시도 회수] 입력값이 빈 값인 경우")
    @Test
    public void checkEmptyInputTest() throws NoSuchMethodException {
        Method method = inputUtils.getClass().getDeclaredMethod("checkEmptyInput", String.class);
        method.setAccessible(true);

        try {
            method.invoke(inputUtils, "");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            assertThat(e.getCause().getMessage()).isEqualTo(ERROR_EMPTY_INPUT);
        }
    }

    @DisplayName("[시도 회수] 입력이 숫자 아닌 경우")
    @Test
    public void invalidAttempInput() throws NoSuchMethodException {
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