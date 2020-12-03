package racingcar.controller;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class InputControllerTest {

    private static HashMap<String,Integer> register = new HashMap<>();

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
                .filter(name -> name.contains(" "))
                .count() > 0;

        //then
        assertThat(isCarNameContainBlank).isTrue();
    }

    @Test
    public void 중복된_참여자_이름을_검증한다() throws Exception {
        //given
        List<String> participants = Arrays.asList("java","c++","java");
        List<String> participants2 = Arrays.asList("java","c++","react");

        //when
        boolean isNameDuplicate = participants.stream()
                .distinct()
                .count() != participants.size();
        boolean isNameDuplicate2 = participants2.stream()
                .distinct()
                .count() != participants.size();

        //then
        assertThat(isNameDuplicate).isTrue();
        assertThat(isNameDuplicate2).isFalse();
    }

    @Test
    public void 중복된_이름뒤에_번호를_부여한다() throws Exception {
        //given
        List<String> participants = Arrays.asList("java","java","java","java1","java11");

        //when
        List<String> result = participants.stream()
                .map(this::nameGenerator)
                .collect(Collectors.toList());
        boolean isDuplicate = result.stream()
                .distinct()
                .count() != participants.size();

        //then
        System.out.println(result);
        assertThat(isDuplicate).isFalse();
    }

    private String nameGenerator(String name) {
        int order = 0;
        if (register.containsKey(name)) {
            order = register.get(name);
            register.put(name, order + 1);
            register.put(name + order, 1);
            name += order;
        }
        if (!register.containsKey(name)) {
            register.put(name, 1);
        }
        return name;
    }

    @Test
    public void 입력값이_숫자인지_검증한다() throws Exception {
        //given
        String input = "-19";   // non pass
        String input2 = "1a";   // non pass
        String input3 = "10";   // pass

        //when
        boolean isInputDigit = input.chars().allMatch(Character::isDigit);
        boolean isInputDigit2 = input2.chars().allMatch(Character::isDigit);
        boolean isInputDigit3 = input3.chars().allMatch(Character::isDigit);

        //then
        assertThat(isInputDigit).isFalse();
        assertThat(isInputDigit2).isFalse();
        assertThat(isInputDigit3).isTrue();
    }
}