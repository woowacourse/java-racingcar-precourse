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
}
