package domain;
/**
 * Created by gram on 2019-12-05.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static String[] carName;
    static int movingNum;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        inputCarName();
        inputMovingNum();
    }

    private static void inputCarName() {
        String totalInputName;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표 기준으로 구분) : ");
        totalInputName = sc.next();
        carName = totalInputName.split(",");
        if( !checkFormAboutName() ) {
            System.out.println("5글자 내로 입력해주세요.");
            inputCarName();
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

    private static void inputMovingNum() {
        System.out.println("시도할 횟수는 몇회인가요?");
        movingNum = sc.nextInt();
    }

}
