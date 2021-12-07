package racingcar;

import camp.nextstep.edu.missionutils.Console;

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
                throw new IllegalArgumentException("[ERROR] 5자 이하의 이름을 입력해주세요.");
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        return MoreThanFive;
    }


    public static String[] getCarName() {
        String[] names;
        boolean MoreThanFive = false;
        do {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 공백없는 쉼표(,) 기준으로 구분)");
            names = Console.readLine().split(",");
        } while (checkMoreThanFive(names, MoreThanFive) == true);

        return names;
    }

    private static int checkLessThanZero(int number) {
        System.out.println("시도할 회수는 몇회인가요?");
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
                throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자로만 입력해주세요.");
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();

            return number;
        }

        try {
            number = Integer.parseInt(input);
            if (number <= 0) {
                throw new IllegalArgumentException("[ERROR] 0보다 큰 정수를 입력해주세요.");
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        return number;
    }

    public static int getNumberOfTimes() {
        int number = -1;

        while (number <= 0) {
            number = checkLessThanZero(number);
        }

        return number;
    }
}
