package domain;

import java.util.*;

enum InputError {
    BLANK("공백 없이 입력해주세요."),
    COUNT_OF_CARS("경기를 위한 자동차 이름을 2개 이상 입력해주세요."),
    UNNAMED("이름이 올바르게 입력되지 않은 자동차가 있습니다. 다시 확인해주세요."),
    LONG_NAME("자동차의 이름은 %자 이하로 입력해주세요"),
    DUPLICATED("자동차의 이름은 중복되지 않도록 입력해주세요."),
    NOT_INTEGER("시도 횟수는 정수로 입력해주세요."),
    SIZE_OF_INTEGER("시도 횟수는 1 이상의 정수로 입력해주세요."),
    PASS("");

    private String message;

    InputError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(int len) {
        if (message.contains("%")) {
            return message.replace("%", String.valueOf(len));
        }
        return message;
    }
}

public class RacingGame {
    private static final int MAX_LEN_OF_CAR_NAME = 5;
    private Scanner scan;

    public RacingGame() {
        scan = new Scanner(System.in);

        guideToInput();
    }

    public void guideToInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = null;
        InputError inputError = null;
        while (inputError != InputError.PASS) {
            input = scan.nextLine();
            inputError = getCorrectNameOfCars(input);
            System.out.println(inputError.getMessage(MAX_LEN_OF_CAR_NAME));
        }
        List<Car> cars = generateCars(input);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String tries = null;
        inputError = null;
        while (inputError != InputError.PASS) {
            tries = scan.next();
            inputError = getCorrectTries(tries);
            System.out.println(inputError.getMessage());
        }

    }

    public InputError getCorrectTries(String input) {
        if (!isInteger(input)) {
            return InputError.NOT_INTEGER;
        }
        int tries = Integer.parseInt(input);
        if (tries < 1) {
            return InputError.SIZE_OF_INTEGER;
        }
        return InputError.PASS;
    }

    public InputError getCorrectNameOfCars(String inputs) {
        if (hasBlank(inputs)) {
            return InputError.BLANK;
        }
        String[] splitted = inputs.split(",");
        if (splitted.length == 1) {
            return InputError.COUNT_OF_CARS;
        }
        if (hasUnnamed(splitted)) {
            return InputError.UNNAMED;
        }
        if (hasTooLongName(splitted)) {
            return InputError.LONG_NAME;
        }
        if (hasDuplicated(splitted)) {
            return InputError.DUPLICATED;
        }
        return InputError.PASS;
    }

    public boolean hasBlank(String str) {
        return str.contains(" ");
    }

    public boolean hasUnnamed(String[] splitted) {
        for (String name : splitted) {
            if (name.equals("")) {
                return true;
            }
        }
        return false;
    }

    public boolean hasTooLongName(String[] splitted) {
        for (String name : splitted) {
            if (name.length() > MAX_LEN_OF_CAR_NAME) {
                return true;
            }
        }
        return false;
    }

    public boolean hasDuplicated(String[] splitted) {
        Set<String> set = new HashSet<>(Arrays.asList(splitted));
        if (splitted.length != set.size()) {
            return true;
        }
        return false;
    }

    public ArrayList<Car> generateCars(String input) {
        ArrayList<Car> list = new ArrayList<>();
        String[] names = input.split(",");
        for (String name : names) {
            list.add(new Car(name));
        }
        return list;
    }

    public boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new RacingGame();
    }
}
