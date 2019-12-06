package domain;

import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        boolean resultValue = true;

        do {
            resultValue = gameUI(resultValue);
        } while (!resultValue);
    }

    private static boolean gameUI(boolean resultValue) {
        RacingCarManager rm = new RacingCarManager();

        if (!resultValue) {
            System.out.println("잘못 입력하였습니다.");
        }
        try {
            resultValue = rm.start();
        } catch (InputMismatchException e) {
            System.out.println("올바른 타입이 아닙니다.");
        }

        return resultValue;
    }
}
