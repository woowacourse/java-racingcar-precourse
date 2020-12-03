package racingcar;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> getCarNames(){
        List<String> names = getCarNamesInput();
        validateNoneEmptyElements(names);
        validateDuplicate(names);
        return names;
    }

    public int getRoundNumber() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("[Error] 시도 횟수는 숫자여야 한다.");
        }
    }

    private List<String> getCarNamesInput() {
        return Arrays.stream(scanner.nextLine().split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private void validateNoneEmptyElements(List<String> names) {
        names.forEach(this::validateNoneEmpty);
    }

    private void validateNoneEmpty(String name) {
        if (name.isEmpty()){
            throw new IllegalArgumentException("[Error] 이름은 공백이면 안된다.");
        }
    }

    private void validateDuplicate(List<String> names) {
        Set<String> set = new HashSet<>();
        for (String name : names) {
            if (set.contains(name)) {
                throw new IllegalArgumentException("[Error] 이름이 같은 참가자가 있습니다.");
            }
            set.add(name);
        }
    }
}
