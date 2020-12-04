package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

class InputUtilsTest {

    public static InputUtils getInputUtils(String inputText) {
        InputStream inputStream = new ByteArrayInputStream(inputText.getBytes());
        System.setIn(inputStream);
        Scanner scanner = new Scanner(inputStream);
        InputUtils inputUtils = InputUtils.of(scanner);
        return inputUtils;
    }

    @Test
    @DisplayName("자동차 이름을 입력 받을 수 있다")
    void testInput() {
        //given
        String inputText = "싱싱이";
        InputUtils inputUtils = getInputUtils(inputText);

        //when
        String[] carNames = inputUtils.getCarNames();

        //then
        assertThat(inputText).isEqualTo(carNames[0]);
    }

    @Test
    @DisplayName("특수문자도 입력받을 수 있다.")
    void testInputSpecialCharacters() {
        //given
        String inputText = "~!@";
        InputUtils inputUtils = getInputUtils(inputText);

        //when
        String[] carNames = inputUtils.getCarNames();

        //then
        assertThat(inputText).isEqualTo(carNames[0]);
    }

    @Test
    @DisplayName("쉼표를 기준으로 이름을 분리할 수 있다.")
    void testSplitCarName() {
        //given
        String inputText = "hello,franc";
        InputUtils inputUtils = getInputUtils(inputText);

        //when
        String[] carNames = inputUtils.splitByRest(inputText);

        //then
        assertThat(carNames[0]).isEqualTo("hello");
        assertThat(carNames[1]).isEqualTo("franc");
    }

    @Test
    @DisplayName("쉼표가 연속 될 시 에러가 발생한다")
    void testSplitsCarName() {
        //given
        String inputText = "hello,,,franc";
        InputUtils inputUtils = getInputUtils(inputText);

        //then
        assertThatThrownBy(() -> inputUtils.splitByRest(inputText))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 연속된 쉼표는 허용하지 않습니다.");
    }

    @Test
    @DisplayName("시도할 회수를 입력받는다")
    void testInputTryCount() {
        //given
        String inputText = "12";
        InputUtils inputUtils = getInputUtils(inputText);

        //when
        int tryCount = inputUtils.getTryCount();

        //then
        assertThat(tryCount).isEqualTo(12);
    }
}
