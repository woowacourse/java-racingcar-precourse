package domain;

import java.util.*;

public class RacingGame {
    private static final int MAX_LEN_OF_CAR_NAME = 5;
    private Scanner scan;

    public RacingGame() {
        scan = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = getNameOfCars();
        List<Car> cars = generateCars(names);

        System.out.println("시도할 횟수는 몇 회인가요?");
        int tries = getTries();

        // 게임 진행 클래스로 데이터 전달


        scan.close();
    }

    public String getNameOfCars() {
        String input = null;
        InputError inputError = null;
        while (inputError != InputError.PASS) {
            input = scan.nextLine();
            inputError = checkAccuracyOfNames(input);
            System.out.println(inputError.getMessage(MAX_LEN_OF_CAR_NAME));
        }
        return input;
    }

    public int getTries() {
        String tries = null;
        InputError inputError = null;
        while (inputError != InputError.PASS) {
            tries = scan.next();
            inputError = checkAccuracyOfTries(tries);
            System.out.println(inputError.getMessage());
        }
        return Integer.parseInt(tries);
    }

    public InputError checkAccuracyOfNames(String input) {
        String[] names = input.split(",");
        if (hasBlank(input) || hasUnnamed(names)) {
            return InputError.BLANK;
        }
        if (names.length == 1) {
            return InputError.COUNT_OF_CARS;
        }
        if (hasTooLongName(names)) {
            return InputError.LONG_NAME;
        }
        if (hasDuplicated(names)) {
            return InputError.DUPLICATED;
        }
        return InputError.PASS;
    }

    public InputError checkAccuracyOfTries(String input) {
        if (!isInteger(input)) {
            return InputError.NOT_INTEGER;
        }
        int tries = Integer.parseInt(input);
        if (tries < 1) {
            return InputError.SIZE_OF_INTEGER;
        }
        return InputError.PASS;
    }

    public boolean hasBlank(String str) {
        return str.contains(" ");
    }

    public boolean hasUnnamed(String[] names) {
        for (String name : names) {
            if (name.equals("")) {
                return true;
            }
        }
        return false;
    }

    public boolean hasTooLongName(String[] names) {
        for (String name : names) {
            if (name.length() > MAX_LEN_OF_CAR_NAME) {
                return true;
            }
        }
        return false;
    }

    public boolean hasDuplicated(String[] names) {
        Set<String> set = new HashSet<>(Arrays.asList(names));
        if (names.length != set.size()) {
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
