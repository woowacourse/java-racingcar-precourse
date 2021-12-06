package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

class InputData {

    private static boolean checkMoreThanFive(String[] names, boolean MoreThanFive) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].length() > 5) {
                MoreThanFive = true;
                break;
            }
        }

        try {
            if (MoreThanFive == true) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println("[ERROR] 5자 이하의 이름을 입력해주세요.");
        }

        return MoreThanFive;
    }


    public static String[] getCarName() {
        String[] names;
        boolean MoreThanFive = false;
        do {
            names = Console.readLine().split(",");
        } while (checkMoreThanFive(names, MoreThanFive) == true);

        System.out.println(Arrays.toString(names));
        return names;
    }

    private static int checkLessThanZero(int number) {
        String input = Console.readLine();
        boolean digitCheck = true;
        for (int i = 0; i < input.length(); i++) {
            char tmp = input.charAt(i);
            if (tmp == '-') {
                continue;
            }
            if (Character.isDigit(tmp) == false) {
                digitCheck = false;
                break;
            }
        }

        try {
            if (digitCheck == false) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println("[ERROR] 시도 횟수는 숫자여야 합니다.");

            return number;
        }

        try {
            number = Integer.parseInt(input);
            if (number <= 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println("[ERROR] 0보다 큰 정수를 입력해주세요.");
        }

        return number;
    }

    public static int getNumberOfTimes() {
        int number = -1;

        while (number <= 0) {
            number = checkLessThanZero(number);
        }

        System.out.println(number);
        return number;
    }
}
