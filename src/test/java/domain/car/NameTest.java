package domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @DisplayName("5글자 이상 이름 생성시")
    @Test
    void test1() {
        String name = "abcde6";
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(name + "은 5글자 보다 긴 이름입니다.");
    }

    @DisplayName("이름 전달")
    @Test
    void test2() {
        String rawName = "abcde";
        Name name = new Name(rawName);
        assertThat(name.getName()).isEqualTo(rawName);
    }
}