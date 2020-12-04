package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class NameTest {

    @DisplayName("Name 객체를 생성하는 기능을 테스트한다")
    @ParameterizedTest
    @ValueSource(strings = {
            "carA", "carB", "carC"
    })
    void testInitName(String inputName) {
        //when
        Name name = new Name(inputName);

        //then
        assertThat(name).extracting("name").isEqualTo(inputName);
    }

    @DisplayName("자동차 이름이 자동차 이름 제한 길이를 만족하지 않는 경우 예외를 발생시킨다")
    @ParameterizedTest
    @ValueSource(strings = {
            "longCarName", "carName"
    })
    @EmptySource
    void testInitNameIfNameNotSatisfiedNameLimitLength(String name) {
        //when //then
        assertThatThrownBy(() -> new Name(name))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름에 공백이 포함되는 경우 예외를 발생시킨다")
    @ParameterizedTest
    @ValueSource(strings = {
            "car A", "car B", " "
    })
    void testInitNameIfNameContainBlank(String name) {
        //when //then
        assertThatThrownBy(() -> new Name(name))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

}
