package racingcar.service;

import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;
import racingcar.service.picker.NumberPicker;

public class CustomNumberPicker implements NumberPicker {

    private List<Integer> numbers;

    public void initNumber(int[] numbers) {
        this.numbers = Arrays.stream(numbers).boxed().collect(Collectors.toList());
    }

    public int pickOne() {
        return numbers.remove(0);
    }

}
