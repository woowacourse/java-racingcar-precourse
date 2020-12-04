package racingcar;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private static final String ERROR_NOT_INTEGER = "[ERROR] 시도 횟수는 숫자여야 한다.";
    private static final String ERROR_NOT_POSITIVE_INTEGER = "[ERROR] 시도 횟수는 양수여야 한다.";
    private static final String ERROR_BLANK_INPUT = "[ERROR] 입력값이 공백이면 안된다.";
    private static final String ERROR_ZERO_PLAYER = "[ERROR] 참가자 수는 한명 이상이여야 한다.";
    private static final String ERROR_BLANK_NAME = "[ERROR] 이름은 공백이면 안된다.";
    private static final String ERROR_LENGTH_OVER_FIVE_NAME = "[ERROR] 이름은 5글자 이하여야 한다.";
    private static final String ERROR_DUPLICATE_NAME = "[ERROR] 이름이 같은 참가자가 있으면 안된다.";
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> getCarNames(){
        List<String> names = getCarNames(scanner.nextLine());
        validateZeroPlayer(names);
        //validateNameLength
        validateBlankName(names);
        validateLengthOverFiveName(names);
        validateDuplicate(names);
        return names;
    }

    private List<String> getCarNames(String inputString) {
        validateBlankInput(inputString);
        return Arrays.stream(inputString.split(","))
                     .map(String::strip)
                     .collect(Collectors.toList());
    }

    public int getRunCount() {
        int number= getRunCount(scanner.nextLine());
        validatePositiveInt(number);
        return number;
    }

    private int getRunCount(String inputString) {
        try {
            return Integer.parseInt(inputString.strip());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_INTEGER);
        }
    }

    private void validateBlankInput(String inputString) {
        if (inputString.isBlank()) {
            throw new IllegalArgumentException(ERROR_BLANK_INPUT);
        }
    }

    private void validateZeroPlayer(List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException(ERROR_ZERO_PLAYER);
        }
    }

    private void validateBlankName(List<String> names) {
        names.forEach(this::validateBlankName);
    }

    private void validateBlankName(String name) {
        if (name.isEmpty()){
            throw new IllegalArgumentException(ERROR_BLANK_NAME);
        }
    }

    private void validateLengthOverFiveName(List<String> names) {
        names.forEach(this::validateLengthOverFiveName);
    }

    private void validateLengthOverFiveName(String name) {
        if (name.length() > 5){
            throw new IllegalArgumentException(ERROR_LENGTH_OVER_FIVE_NAME);
        }
    }

    private void validateDuplicate(List<String> names) {
        Set<String> set = new HashSet<>();
        names.forEach(name -> {
            if (set.contains(name)) {
                throw new IllegalArgumentException(ERROR_DUPLICATE_NAME);
            }
            set.add(name);
        });
    }

    private void validatePositiveInt(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(ERROR_NOT_POSITIVE_INTEGER);
        }
    }
}
