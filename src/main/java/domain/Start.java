/*
 * Start
 *
 * ver 1.0
 *
 * 2019.12.07
 *
 * CopyRight
 *
 */
package domain;

import java.util.ArrayList;
import java.util.Scanner;

public class Start {
    /*
     * Start 클래스 입니다.
     * 게임을 시작시키고 게임에 필요한 객체를 생성하고 입력을 받습니다.
     */
    public static void game() { // 게임을 시작시키고 유저가 입력한 조건에 맞게 객체를 생성시킵니다.
        String carName;
        int tryChance;
        carName = requestCarName();
        String[] carNameList = splitCarName(carName);
        if (checkNameList(carNameList)) {
            ArrayList<Car> carList = makeCar(carNameList);
            tryChance = requestTry();
            Compare.showAll(tryChance, carList);
        } else {
            System.out.println("길이가 5를 넘는 이름을 삽입하셨습니다. 게임을 종료합니다");
        }
    }

    public static Boolean checkNameList(String[] carNameList) { // 객체이름리스트에 길이가 5이상이 있는지 없는지 확인합니다.
        int index = 0;
        while (checkName(carNameList, index)) {
            index++;
        }
        if (index == carNameList.length) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean checkName(String[] carNameList, int index) { // 객체이름의 길이가 5이상인지 아닌지를 확인합니다.
        if (index == carNameList.length) {
            return false;
        } else if(carNameList[index].length() > 5) {
            return false;
        } else {
            return true;
        }
    }

    public static String requestCarName() { // 객체의 이름을 입력받는 메소드 입니다.
        String carName;
        Scanner scan = new Scanner(System.in);
        System.out.println("경주할자동차이름을입력하세요.(이름은쉼표(,)기준으로구분)");
        carName = scan.nextLine();
        return carName;
    }

    public static int requestTry() { // 몇변 시도할것인지에 대한 입력을 받는 메소드 입니다.
        int tryChance;
        Scanner scan = new Scanner(System.in);
        System.out.println("시도할 횟수는 몇회인가요");
        tryChance = scan.nextInt();
        return tryChance;
    }

    public static String[] splitCarName(String carName) { // ','를 기준으로 문자열을 파싱해서 string 배열로 반환해주는 메소드 입니다.
        String[] carNameList = carName.split(",");
        return carNameList;
    }

    public static ArrayList<Car> makeCar(String[] carNameList) { // 객체를 생성시켜주는 메소드 입니다.
        ArrayList<Car> carList = new ArrayList<Car>();
        for (int index = 0; index < carNameList.length; index++) {
            Car createCar = new Car(carNameList[index]);
            carList.add(createCar);
        }
        return carList;
    }

}
