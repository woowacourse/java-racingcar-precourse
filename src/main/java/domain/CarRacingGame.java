package domain;

import java.util.ArrayList;
import java.util.Scanner;

public class CarRacingGame {
    private static boolean checkNameLength(String[] carName) {
        boolean checkResult = true;

        for (String e : carName) {
            if (e.length() > 5) {
                checkResult = false;
            }
        }

        return checkResult;
    }

    public static void main(String[] args) {
        boolean isRightNames = false;
        String[] carName = new String[0];

        while (!isRightNames) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("경주할 자동차의 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분) \n");
            String input = scanner.nextLine();

            carName = input.split(",");

            isRightNames = checkNameLength(carName);
        }

        ArrayList<Car> carList = new ArrayList<>();
        ArrayList<String> carTraces = new ArrayList<>();

        for (String e : carName) {
            Car car = new Car(e);
            String trace = "";

            carList.add(car);
            carTraces.add(trace);
        }
    }
}
