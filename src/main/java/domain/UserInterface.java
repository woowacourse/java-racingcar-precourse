package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UserInterface {
    private Scanner sc = new Scanner(System.in);

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private static final int MIN_NUMBER = 1;

    public String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.");
        return sc.nextLine().split(",");
    }

    public boolean checkValidationCarNames(String[] carNames) {
        int length;

        for (String carName : carNames) {
            length = carName.length();
            if ((length < MIN_LENGTH) || (length > MAX_LENGTH)) {
                return false;
            }
        }

        return true;
    }

    public String inputCnt() {
        System.out.println("시도할 회수는 몇회인가요?");
        return sc.next();
    }

    public boolean checkValidationCnt(String cntStr) {
        int cnt;
        try {
            cnt = Integer.parseInt(cntStr);
        } catch (NumberFormatException e) {
            return false;
        }

        return (cnt > MIN_NUMBER);
    }

    public void printResultMenu() {
        System.out.println("\n실행결과");
    }

    public void printRacing(Car[] cars) {
        int position;

        for (Car car : cars) {
            position = car.getPosition();
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < position; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printWinners(Car[] cars) {
        ArrayList<Integer> positions = new ArrayList<>();

        for (Car car : cars) {
            positions.add(car.getPosition());
        }

        int maxPosition = Collections.max(positions);
        for (Car car : cars) {
            printWinnerNames(car, maxPosition);
        }
        System.out.println("가 최종 우승했습니다.");
    }

    private boolean flag = true;

    private void printWinnerNames(Car car, int maxPosition) {
        if (car.getPosition() == maxPosition) {
            if (flag) {
                System.out.print(car.getName());
                flag = false;
            } else {
                System.out.print(", " + car.getName());
            }
        }
    }
}
