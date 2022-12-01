package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarNamesTest {
    final static String ERROR = "[ERROR]";

    @Test
    @CsvSource({"'pobi,woni,jun'", "sk12"})
    void readCarNames_자동차_이름을_입력받는다(String input) {
        assertThat(carNames(input)).isEqualTo(input.split(","));
    }

    @Test
    @CsvSource({
            "'pobi,,jun'",
            "", ", , , ,",
            "'chooooovy, pobi'",
    })
    void readCarNames_이름_길이가_해당_범위가_아니라면_에러를_발생시킨다(String input) {
        Assertions.assertThatThrownBy(() -> carNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR);
    }
}
