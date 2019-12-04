package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        init();
    }

    private static void init() {
        String carNames;
        List<Car> carsList = new ArrayList<Car>();
        carNames = inputCarNames();
        System.out.println(carNames);
    }

    private static String inputCarNames() {
        String carNames;
        Scanner scan = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carNames = scan.nextLine();
        return carNames;
    }

}