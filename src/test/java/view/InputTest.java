package view;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputTest {
    @Test
    public void initTest() {
        Input input = new Input();
        assertThat(input).isNotNull();
    }

    @Test
    public void splitAsCommaTest() {
        Input input = new Input();
        assertThat(input.splitAsComma("pobi,crong,honux").toString())
                .isEqualTo("[pobi, crong, honux]");
    }

    @Test
    public void isPositiveIntegerTest() {
        Input input = new Input();
        assertThat(input.isPositiveInteger("8")).isTrue();
        assertThat(input.isPositiveInteger("0")).isFalse();
        assertThat(input.isPositiveInteger("-7")).isFalse();
        assertThat(input.isPositiveInteger("한글")).isFalse();
        assertThat(input.isPositiveInteger("English")).isFalse();
        assertThat(input.isPositiveInteger("")).isFalse();
        assertThat(input.isPositiveInteger(" ")).isFalse();
        assertThat(input.isPositiveInteger("\n")).isFalse();
    }

    @Test
    public void isNamesLengthUnderMaxTest() {
        Input input = new Input();
        assertThat(input.isNamesLengthUnderMax(input.splitAsComma("가,나다,라마바," +
                "사아자차,카타파하가"))).isTrue();
        assertThat(input.isNamesLengthUnderMax(input.splitAsComma("가,나다,라마바," +
                "사아자차,666666"))).isFalse();
    }

    @Test
    public void isNoBlankNamesTest() {
        Input input = new Input();
        assertThat(input.isNoBlankNames(input.splitAsComma("1,우,2"))).isTrue();
        assertThat(input.isNoBlankNames(input.splitAsComma("1,,2"))).isFalse();
        assertThat(input.isNoBlankNames(input.splitAsComma("1, ,2"))).isFalse();
    }
}