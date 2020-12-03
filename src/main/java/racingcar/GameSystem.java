package racingcar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GameSystem {
    private static final int MIN_CAR_COUNT = 2;
    private static final int MIN_TRIAL_COUNT = 1;
    private static final int MAX_NAME_LENGTH = 5;

    private int carCount;
    private int trialCount;
    private int maxPosition;
    private Car[] cars;


    public GameSystem() {
        this.carCount = 0;
        this.trialCount = 0;
        this.maxPosition = 0;
    }

    public int getTrialCount() {
        return trialCount;
    }

    public Car[] getCars() {
        return cars;
    }

    public void setTrialCount(Scanner scanner) {
        String input;

        while (true) {
            System.out.println("시도할 회수는 몇회인가요?");
            input = scanner.nextLine();
            try {
                checkValidTrialCount(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        this.trialCount = Integer.parseInt(input);
    }

    private void setCars(String[] names) {
        this.carCount = names.length;

        cars = new Car[carCount];
        for (int i = 0; i < carCount; i++) {
            Car car = new Car(names[i]);
            cars[i] = car;
        }
    }

    private void setMaxPosition() {
        int max = 0;

        for (int i = 0; i < carCount; i++) {
            int position = cars[i].getPosition();
            if (position >= max) {
                maxPosition = position;
            }
        }
    }

    public void makeCars(Scanner scanner) {
        String[] tmpNames;

        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표 (,) 기준으로 구분)");
            String input = scanner.nextLine();
            tmpNames = parseCarNames(input);
            try {
                checkValidCars(tmpNames);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        setCars(tmpNames);
    }

    public void doAllTrial() {
        System.out.println("실행 결과");

        for (int i = 0; i < trialCount; i++) {
            doOneTrial();
        }
    }

    public void set

    private void doOneTrial() {
        driveAllCars();
        printPositionAllCars();
    }

    private void driveAllCars() {
        for (int i = 0; i < carCount; i++) {
            cars[i].action();
        }
    }

    private void printPositionAllCars() {
        for (int i = 0; i < carCount; i++) {
            cars[i].printPosition();
        }
        System.out.println();
    }

    private String[] parseCarNames(String string) {
        String[] tmpNames;

        tmpNames = string.split(",");
        return tmpNames;
    }

    private void checkValidCars(String[] names) throws IllegalArgumentException {
        if (!checkValidCount(names)) {
            throw new IllegalArgumentException("[ERROR] 최소 2개 이상의 차가 존재해야 합니다.");
        }
        if (!checkNoSpace(names)) {
            throw new IllegalArgumentException("[ERROR] 입력이 공백을 포함하지 않아야 합니다.");
        }
        if (!checkAllDiff(names)) {
            throw new IllegalArgumentException("[ERROR] 중복되는 차 이름이 존재하지 않아야 합니다.");
        }
        if (!checkAllValid(names)) {
            throw new IllegalArgumentException("[ERROR] 차 이름의 길이는 5자 이하여야 합니다.");
        }
    }

    private void checkValidTrialCount(String string) throws IllegalArgumentException {
        if (string.equals("")) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 1이상의 정수여야 합니다.");
        }
        if (!checkAllDigit(string)) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 1이상의 정수여야 합니다.");
        }
        if (!checkPositive(string)) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 1이상의 정수여야 합니다.");
        }
    }

    private boolean checkValidCount(String[] names) {
        int size = names.length;

        if (size < MIN_CAR_COUNT) {
            return false;
        }
        return true;
    }

    private boolean checkNoSpace(String[] names) {
        int size = names.length;

        for (int i = 0; i < size; i++) {
            if (names[i].contains(" ")) {
                return false;
            }
        }
        return true;
    }

    private boolean checkAllDiff(String[] names) {
        Set<String> nameSet = new HashSet<>(Arrays.asList(names));
        int arraySize = names.length;
        int setSize = nameSet.size();

        if (arraySize != setSize) {
            return false;
        }
        return true;
    }

    private boolean checkAllValid(String[] names) {
        int size = names.length;

        for (int i = 0; i < size; i++) {
            if (names[i].length() > MAX_NAME_LENGTH) {
                return false;
            }
        }
        return true;
    }

    private boolean checkAllDigit(String string) {
        int length = string.length();

        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(string.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean checkPositive(String string) {
        int num = Integer.parseInt(string);

        if (num < MIN_TRIAL_COUNT) {
            return false;
        }
        return true;
    }
}
