package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static int CountingGame() {
        System.out.println("시도할 회수는 몇회인가요?");
        String str = Console.readLine();
        try {
            int counting = Integer.parseInt(str);
            if (counting <= 0) {
                System.out.println("0보다 큰 자연수를 입력해주세요");
                return CountingGame();
            }
            System.out.println();
            return counting;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
            return CountingGame();
        }
    }

    public static String[] inputToArray() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String inputCarName = Console.readLine();
        try {
            String[] arrayCar = inputCarName.split(",");
            if (CheckFiveChar(arrayCar)) {
                return arrayCar;
            }
            return inputToArray();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 이름을 입력해주세요!");
            return inputToArray();
        }
    }

    private static boolean CheckFiveChar(String[] arrayCar) {
        boolean flag = true;
        for (int i = 0; i < arrayCar.length; i++) {
            if (arrayCar[i].length() > 5) {
                flag = false;
            }
        }
        if (flag) {
            return true;
        }
        throw new IllegalArgumentException("[ERROR] : 자동차 이름이 5글자를 넘어요!");
    }

    public static Car[] arrayCarObj(String[] arrayCar) {
        Car[] arrayCarObj = new Car[arrayCar.length];
        for (int i = 0; i < arrayCar.length; i++) {
            arrayCarObj[i] = new Car(arrayCar[i]);
        }
        return arrayCarObj;
    }
}
