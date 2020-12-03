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
        String nextLine = inputUtils.inputAndGetCarName();

        //then
        assertThat(inputText).isEqualTo(nextLine);
    }

    @Test
    @DisplayName("특수문자도 입력받을 수 있다.")
    void testInputSpecialCharacters() {
        //given
        String inputText = "~!@,";
        InputUtils inputUtils = getInputUtils(inputText);

        //when
        String nextLine = inputUtils.inputAndGetCarName();

        //then
        assertThat(inputText).isEqualTo(nextLine);
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
}
