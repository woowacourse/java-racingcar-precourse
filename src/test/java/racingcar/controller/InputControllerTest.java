package racingcar.controller;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputControllerTest {

    @Test
    public void 자동차_이름_길이가_5_이하이다() throws Exception {
        //given
        List<String> participants = Arrays.asList("java","c++","react");
        int nameMaxLength = 5;
        //when
        boolean isCarNameLength5OrLess = participants.stream()
                .filter(name -> name.length() <= nameMaxLength)
                .count() == participants.size();
        //then
        assertThat(isCarNameLength5OrLess).isTrue();
    }

    @Test
    public void 자동차_이름에_공백을_확인한다() throws Exception {
        //given
        List<String> participants = Arrays.asList("java","c++","re ct");

        //when
        boolean isCarNameContainBlank = participants.stream()
                .filter(name -> !name.contains(" "))
                .count() == participants.size();

        //then
        assertThat(isCarNameContainBlank).isFalse();
    }
}