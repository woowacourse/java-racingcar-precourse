package domain;

import java.util.*;

public class RacingGameConfig {
    private static final int MAX_LEN_OF_CAR_NAME = 5;
    private Scanner scan = new Scanner(System.in);
    private ArrayList<Car> cars = new ArrayList<>();
    private int tries;

    public RacingGameConfig(ArrayList<Car> cars, int tries) {
        this.cars = cars;
        this.tries = tries;
    }

    public RacingGameConfig() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] names = getNameOfCarsFromUser();
        cars = generateCars(names);

        System.out.println("시도할 횟수는 몇 회인가요?");
        tries = getTriesFromUser();
    }

    public String[] getNameOfCarsFromUser() {
        String input = null;
        InputError inputError = null;
        while (inputError != InputError.PASS) {
            input = scan.nextLine();
            inputError = checkAccuracyOfNames(input);
            System.out.println(inputError.getMessage(MAX_LEN_OF_CAR_NAME));
        }
        return input.split(",");
    }

    public int getTriesFromUser() {
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

    public ArrayList<Car> generateCars(String[] names) {
        ArrayList<Car> list = new ArrayList<>();
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

    public ArrayList<Car> getCars() {
        return cars;
    }

    public int getTries() {
        return tries;
    }
}
