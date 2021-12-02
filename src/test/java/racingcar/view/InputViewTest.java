package racingcar.view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    private static InputStream generateStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    private static InputView generateInputView() {
        return new InputView();
    }

    @DisplayName("경주할 자동차 이름을 입력 받으면 쉼표를 기준으로 나눠 리스트를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun"})
    void getNames_inputNames_ListReturn(String inputNames) {
        // given
        System.setIn(generateStream(inputNames));
        InputView inputView = generateInputView();

        // when
        List<String> names = inputView.getNames();

        // then
        assertThat(names).isInstanceOf(List.class);
    }

    @DisplayName("시도할 회수를 입력하면 검증을 거쳐 시도 회수를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    void getTryCount_inputTryCount_intReturn(String inputTryCount) {
        // given
        System.setIn(generateStream(inputTryCount));
        InputView inputView = generateInputView();

        // when
        int tryCount = inputView.getTryCount();

        // then
        assertThat(tryCount).isEqualTo(Integer.parseInt(inputTryCount));
    }
}