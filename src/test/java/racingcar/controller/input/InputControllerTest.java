package racingcar.controller.input;

import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class InputControllerTest {


    @Test
    @Description("Scanner로 입력 받은 문자열을 설정된 구분자(,)를 기준으로 자른다.")
    public void inputNameTest() {
        //given
        String input = "aaa,bbb,ccc,ddd,eee,fff";
        InputController inputController = getInputController(input);

        //when
        String[] result = inputController.inputNames();
        String[] expected = input.split(",");

        //then
        Assertions.assertArrayEquals(expected, result);
    }

    public Scanner getMockScanner(String input) {
        Scanner mock = mock(Scanner.class);
        when(mock.nextLine()).thenReturn(input);
        return mock;
    }

    public InputController getInputController(String input) {
        Scanner mockScanner = getMockScanner(input);
        return new InputController(mockScanner);
    }


}