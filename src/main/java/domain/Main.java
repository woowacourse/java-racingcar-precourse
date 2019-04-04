package domain;

import java.util.Scanner;

public class Main {
    private static final String CAR_NAME_SEPARATOR = ",";

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
}
