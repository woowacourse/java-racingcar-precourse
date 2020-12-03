package racingcar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GameSystem {
    private static final int MIN_CAR_COUNT = 2;
    private static final int MAX_NAME_LENGTH = 5;

    public GameSystem() {
    }

    public void makeCars(Scanner scanner) {
        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표 (,) 기준으로 구분)");
            String input = scanner.nextLine();
            String[] tmpNames = parseCarNames(input);
            try {
                checkValidCars(tmpNames);
                break;
            } catch (IllegalArgumentException e) {
                String message = e.getMessage();
                System.out.println(message);
            }
        }
    }

    public String[] parseCarNames(String string) {
        String[] tmpNames;

        tmpNames = string.split(",");
        return tmpNames;
    }

    public void checkValidCars(String[] names) throws IllegalArgumentException {
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
}
