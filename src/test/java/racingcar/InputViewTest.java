package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {
    final static String ERROR = "[ERROR]";
    InputView inputView = new InputView();

    @Test
    @CsvSource({"'pobi,woni,jun'", "sk12"})
    void carNames_자동차_이름을_입력받는다(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThat(inputView.carNames()).isEqualTo(input.split(","));
    }

    @Test
    @CsvSource({
            "'pobi,,jun'",
            "", ", , , ,",
            "'chooooovy, pobi'",
    })
    void carNames_이름_길이가_해당_범위가_아니라면_에러를_발생시킨다(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Assertions.assertThatThrownBy(() -> inputView.carNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR);
    }
}
