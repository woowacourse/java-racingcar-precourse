package com.codemcd.racingcar;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputErrorTest {

    @Test
    public void isInputCarNameFormat_Normal_Input() {
        String input = "pobi,crong,honux";

        boolean isValid = InputError.isInputCarNameFormat(input);

        assertThat(isValid).isTrue();
    }

    @Test
    public void isInputCarNameFormat_Overlap_Comma_Input() {
        String input = "pobi,,crong,honux";

        boolean isValid = InputError.isInputCarNameFormat(input);

        assertThat(isValid).isFalse();
    }

    @Test
    public void isInputCarNameFormat_Overrun_Name_Size_Input() {
        String input = "pobi,crong,honux,Antonio";

        boolean isValid = InputError.isInputCarNameFormat(input);

        assertThat(isValid).isFalse();
    }

    @Test
    public void isNumeric_Normal_Input() {
        String input = "10";

        boolean isValid = InputError.isNumeric(input);

        assertThat(isValid).isTrue();
    }

    @Test
    public void isNumeric_Not_Number_Input() {
        String input = "abc";

        boolean isValid = InputError.isNumeric(input);

        assertThat(isValid).isFalse();
    }
}