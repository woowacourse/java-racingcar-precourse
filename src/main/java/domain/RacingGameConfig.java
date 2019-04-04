package domain;

import java.util.*;

public class RacingGameConfig {
    private static final int MAX_LEN_OF_CAR_NAME = 5;
    private Scanner scan = new Scanner(System.in);
    private ArrayList<Car> cars;
    private int tries;

    public RacingGameConfig() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] names = getNameOfCarsFromUser();
        cars = generateCars(names);

        System.out.println("시도할 횟수는 몇 회인가요?");
        tries = getTriesFromUser();
    }

    public RacingGameConfig(String nameInput, int tries) {
        Validator validator = new Validator(MAX_LEN_OF_CAR_NAME);
        String[] names = nameInput.split(",");
        if (!validator.checkAccuracyOfNames(names)) {
            InputError inputError = validator.getInputError();
            System.out.println(inputError.getMessage());
            return;
        }
        this.cars = generateCars(names);
        this.tries = tries;
    }

    public String[] getNameOfCarsFromUser() {
        Validator validator = new Validator(MAX_LEN_OF_CAR_NAME);
        String input;
        while (true) {
            input = scan.nextLine();
            String[] names = input.split(",");
            if (validator.checkAccuracyOfNames(names)) {
                break;
            }
            InputError inputError = validator.getInputError();
            System.out.println(inputError.getMessage());
        }
        return input.split(",");
    }

    public int getTriesFromUser() {
        Validator validator = new Validator(MAX_LEN_OF_CAR_NAME);
        String tries;
        while (true) {
            tries = scan.next();
            if( validator.checkAccuracyOfTries(tries)) {
                break;
            }
            InputError inputError = validator.getInputError();
            System.out.println(inputError.getMessage());
        }
        return Integer.parseInt(tries);
    }

    public ArrayList<Car> generateCars(String[] names) {
        ArrayList<Car> list = new ArrayList<>();
        for (String name : names) {
            list.add(new Car(name.trim()));
        }
        return list;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public int getTries() {
        return tries;
    }
}
