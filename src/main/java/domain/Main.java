package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        init();
    }

    private static void init() {
        List<Car> carsList = inputCarNames();
        for(int i = 0; i < carsList.size(); i++) {
            carsList.get(i).proceed();
        }
    }

    private static List<Car> inputCarNames() {
        String carNames;
        List<Car> carsList;
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            carNames = scan.nextLine();
            carsList = enrollPlayers(carNames);
            return carsList;
        }
    }

    private static List<Car> enrollPlayers(String carNames) {
        String[] carArray = carNames.split(",");
        List<Car> carsList = new ArrayList<Car>();
        for (int i = 0; i < carArray.length; i++) {
            carsList.add(new Car(carArray[i]));
        }
        return carsList;
    }
}