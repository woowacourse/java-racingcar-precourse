package racingcar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Application {
    private static final int NO_CAR_ERROR = 0;
    private static final int NO_INT_ERROR = 1;
    private static final int LENGTH_RANGE_ERROR = 2;
    private static final int SAME_NAME_ERROR = 3;
    private static final int MIN_CAR_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int CAR_NAME_CASE = 0;
    private static final int GAME_COUNT_CASE = 1;
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Car[] cars = gameSetting(scanner);
        displayInputMessage(GAME_COUNT_CASE);
        scanner.close();
    }

    private static Car[] gameSetting(Scanner kbd) {
        displayInputMessage(CAR_NAME_CASE);
        String[] names = inputCarNames(kbd);
        boolean check = checkCarNames(names);
        while (!check) {
            displayInputMessage(CAR_NAME_CASE);
            names = inputCarNames(kbd);
            check = checkCarNames(names);
        }
        Car[] cars = makeCars(names);
        return cars;
    }

    private static Car[] makeCars(String[] names) {
        Car[] cars = new Car[names.length];
        for (int i = 0; i < names.length; i++) {
            cars[i] = new Car(names[i]);
        }
        return cars;
    }

    private static void displayInputMessage(int inputCase) {
        if (inputCase == CAR_NAME_CASE)
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        if (inputCase == GAME_COUNT_CASE)
            System.out.println("시도할 회수는 몇회인가요?");
    }

    private static String[] inputCarNames(Scanner kbd) {
        String input = kbd.nextLine();
        StringTokenizer tokens = new StringTokenizer(input, ", ");
        int countTokens = tokens.countTokens();
        String[] names = new String[countTokens];
        for (int i = 0; i < countTokens; i++) {
            names[i] = tokens.nextToken();
        }
        return names;
    }

    private static boolean checkCarNames(String[] names) {
        boolean check = true;
        check = checkCarsLength(names, check);
        for (int i = 0; i < names.length; i++) {
            check = checkNameLength(names[i], check);
        }
        check = checkSameName(names, check);
        return check;
    }

    private static boolean checkCarsLength(String[] names, boolean check) {
        if (names.length < MIN_CAR_LENGTH) {
            check = false;
            displayErrorMessage(NO_CAR_ERROR);
        }
        return check;
    }

    private static boolean checkNameLength(String name, boolean check) {
        if (name.length() > MAX_NAME_LENGTH) {
            check = false;
            displayErrorMessage(LENGTH_RANGE_ERROR);
        }
        return check;
    }

    private static boolean checkSameName(String[] names, boolean check) {
        HashSet<String> namesSet = new HashSet<>();
        namesSet.addAll(Arrays.asList(names));
        if (names.length != namesSet.size()) {
            check = false;
            displayErrorMessage(SAME_NAME_ERROR);
        }
        return check;
    }

    private static void displayErrorMessage(int errorCase) {
        if (errorCase == NO_CAR_ERROR)
            System.out.println("[ERROR] 경주할 자동차를 2대 이상 입력해주세요");
        if (errorCase == LENGTH_RANGE_ERROR)
            System.out.println("[ERROR] 이름은 5자 이하로 입력해주세요");
        if (errorCase == NO_INT_ERROR)
            System.out.println("[ERROR] 시도 횟수는 숫자여야 한다");
        if (errorCase == SAME_NAME_ERROR)
            System.out.println("[ERROR] 이름을 중복하여 사용할 수 없습니다");
    }
}