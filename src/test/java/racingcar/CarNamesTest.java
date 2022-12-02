package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarNamesTest {

    @ParameterizedTest
    @CsvSource({"'pobi,woni,jun'", "sk12"})
    void CarNames_자동차_이름을_입력받는다(String input) {
        System.out.println(input);
        assertThat(new CarNames(input.split(",")))
                .hasNoNullFieldsOrProperties();
    }

    @Test
    void CarNames_이름_길이가_해당_범위가_아니라면_에러를_발생시킨다() {
        Assertions.assertThatThrownBy(() -> new CarNames(new String[] {"chooooovy", "pobi"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 1글자 이상 5글자 이하여야 합니다");
    }
}
