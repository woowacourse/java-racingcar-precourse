package domain;
/**
 * Created by gram on 2019-12-05.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static String[] carName;
    public static void main(String[] args) {
        createCar();
        
    }

    private static void createCar() {
        String totalInputName;
        Scanner sc = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표 기준으로 구분) : ");
        totalInputName = sc.next();
        carName = totalInputName.split(",");
        if( !checkFormAboutName() ) {
            System.out.println("5글자 내로 입력해주세요.");
            createCar();
        }
    }

    private static boolean checkFormAboutName() {
        for(int i = 0; i < carName.length; i++) {
            if(carName[i].length() > 5) {
                return false;
            }
        }
        return true;
    }
}
