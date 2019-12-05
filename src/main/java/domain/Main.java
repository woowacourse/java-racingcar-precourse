package domain;
/**
 * Created by gram on 2019-12-05.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //car 이름 입력받아 생성하는 메소드 호출
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표 기준으로 구분)");
        createCar();
    }

    private static void createCar() {
        String[] carName;
        String totalInputName;
        Scanner sc = new Scanner(System.in);

        totalInputName = sc.next();
        carName = totalInputName.split(",");

    }

}
