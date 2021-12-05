package racingcar.view;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.domain.trycount.TryCount;

class InputViewTest {

    private static InputStream generateStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    private static InputView generateInputView() {
        return new InputView();
    }

    static Stream<Arguments> getNamesMethodSourceProvider() {
        return Stream.of(
            arguments("pobi,woni,jun", 3),
            arguments(",,,,", 5),
            arguments(",pobi,", 3),
            arguments(" , ,, , ", 5),
            arguments("pobi", 1)
        );
    }

    @DisplayName("경주할 자동차 이름을 입력 받으면 쉼표를 기준으로 나눠 리스트를 반환한다.")
    @ParameterizedTest
    @MethodSource("getNamesMethodSourceProvider")
    void getNames_inputNames_ListReturn(String inputNames, int size) {
        // given
        System.setIn(generateStream(inputNames));
        InputView inputView = generateInputView();

        // when
        List<String> names = inputView.getNames();

        // then
        System.out.println(names);
        assertThat(names).isInstanceOf(List.class);
        assertThat(names.size()).isEqualTo(size);
    }

    @DisplayName("시도할 회수를 입력하면 검증을 거쳐 시도 회수를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    void getTryCount_inputTryCount_TryCountReturn(String inputTryCount) {
        // given
        System.setIn(generateStream(inputTryCount));
        InputView inputView = generateInputView();

        // when
        TryCount tryCount = inputView.getTryCount();

        // then
        assertThat(tryCount).isInstanceOf(TryCount.class);
    }

    @DisplayName("시도할 회수가 숫자가 아니면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "1a", " "})
    void getTryCount_InputTryCountThenNotNumberFormat_ExceptionThrown(String inputTryCount) {
        // given
        System.setIn(generateStream(inputTryCount));
        InputView inputView = generateInputView();

        // when & then
        assertThatThrownBy(() -> {
            inputView.getTryCount();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도할 회수가 음수이면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-2", "-3", "-4", "-5"})
    void getTryCount_InputTryCountThenNegativeNumber_ExceptionThrown(String inputTryCount) {
        // given
        System.setIn(generateStream(inputTryCount));
        InputView inputView = generateInputView();

        // when & then
        assertThatThrownBy(() -> {
            inputView.getTryCount();
        }).isInstanceOf(IllegalArgumentException.class);
    }
}