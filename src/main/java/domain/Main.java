package domain;

import java.util.Scanner;

public class Main {
    private static final String CAR_NAME_SEPARATOR = ",";
    private static final int NAME_LENGTH_UPPER_BOUNDARY = 5;

    public static String[] inputCarName() {
        Scanner scan = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요.");
        String input_car_name_user = scan.nextLine();
        String[] inputCar = input_car_name_user.split(CAR_NAME_SEPARATOR);
        return inputCar;
    }

    public static int countCleanName(boolean[] check) {
        int count = 0;

        for (int i = 0; i < check.length; i++) {
            if (check[i] == false) {
                count++;
            }
        }
        return count;
    }

    public static String[] saveCarName(String[] tempCarName, boolean[] check) {
        int trial = 0;
        int count = countCleanName(check);

        String[] carSave = new String[count];
        for (int i = 0; i < check.length; i++) {
            if (!check[i]) {
                carSave[trial] = tempCarName[i]; //carSave에 순서대로 값 저장
                trial++;
            }
        }
        return carSave;
    }

    public static String[] checkCarName() {
        String[] tempCarName = inputCarName();
        boolean[] check = new boolean[tempCarName.length];

        for (int i = 0; i < tempCarName.length; i++) {
            if (tempCarName[i].length() > NAME_LENGTH_UPPER_BOUNDARY || tempCarName[i].equals("")) {
                check[i] = true; // 적합하지 않은 입력값 true로 구분
            }
        }
        String[] carFinish = saveCarName(tempCarName, check);
        return carFinish;
    }

    public static void printResult(Car[] cars) {
        String winners = "";
        int max = 0;

        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getPosition() > max) {
                max = cars[i].getPosition();
            }
        }
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getPosition() == max) {
                winners = winners.concat(cars[i].getName() + ", ");
            }
        }
        winners = winners.substring(0, winners.length() - 2);
        System.out.println(winners + "가(이) 최종우승 했습니다.");
    }
}
