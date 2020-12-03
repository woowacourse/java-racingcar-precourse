package racingcar;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private static final String ERROR_NOT_INTEGER = "[ERROR] 시도 횟수는 숫자여야 한다.";
    private static final String ERROR_NOT_POSITIVE_INTEGER = "[ERROR] 시도 횟수는 양수여야 한다.";
    private static final String ERROR_BLANK_INPUT = "[ERROR] 입력값이 공백이면 안됩니다.";
    private static final String ERROR_ZERO_PLAYER = "[ERROR] 참가자 수는 한명 이상이여야 합니다.";
    private static final String ERROR_BLANK_NAME = "[ERROR] 이름은 공백이면 안된다.";
    private static final String ERROR_DUPLICATE_NAME = "[ERROR] 이름이 같은 참가자가 있습니다.";
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> getCarNames(){
        List<String> names = getCarNames(scanner.nextLine());
        validateZeroPlayer(names);
        validateBlankElements(names);
        validateDuplicate(names);
        return names;
    }

    private List<String> getCarNames(String inputString) {
        validateBlankInput(inputString);
        return Arrays.stream(inputString.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public int getRoundNumber() {
        int number= getRoundNumber(scanner.nextLine());
        validatePositiveInt(number);
        return number;
    }

    private int getRoundNumber(String inputString) {
        try {
            return Integer.parseInt(inputString.trim());
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

    private void validateBlankElements(List<String> names) {
        System.out.println(names);
        names.forEach(this::validateBlankName);
    }

    private void validateBlankName(String name) {
        if (name.isEmpty()){
            throw new IllegalArgumentException(ERROR_BLANK_NAME);
        }
    }

    private void validateDuplicate(List<String> names) {
        Set<String> set = new HashSet<>();
        for (String name : names) {
            if (set.contains(name)) {
                throw new IllegalArgumentException(ERROR_DUPLICATE_NAME);
            }
            set.add(name);
        }
    }

    private void validatePositiveInt(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(ERROR_NOT_POSITIVE_INTEGER);
        }
    }
}
