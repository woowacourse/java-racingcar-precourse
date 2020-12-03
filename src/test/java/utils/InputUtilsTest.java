package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

class InputUtilsTest {

    @Test
    @DisplayName("자동차 이름을 입력 받을 수 있다")
    void testInput() {
        //given
        String inputText = "싱싱이";
        InputStream inputStream = new ByteArrayInputStream(inputText.getBytes());
        System.setIn(inputStream);
        Scanner scanner = new Scanner(inputStream);
        InputUtils inputUtils = InputUtils.of(scanner);

        //when
        String nextLine = inputUtils.inputAndReturnCarName();

        //then
        assertThat(inputText).isEqualTo(nextLine);
    }

    @Test
    @DisplayName("특수문자도 입력받을 수 있다.")
    void testInputSpecialCharacters() {
        //given
        String inputText = "~!@.";
        InputStream inputStream = new ByteArrayInputStream(inputText.getBytes());
        System.setIn(inputStream);
        Scanner scanner = new Scanner(inputStream);
        InputUtils inputUtils = InputUtils.of(scanner);

        //when
        String nextLine = inputUtils.inputAndReturnCarName();

        //then
        assertThat(inputText).isEqualTo(nextLine);
    }
}