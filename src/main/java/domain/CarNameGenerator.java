/**
 * Copyright (c) 2019 Seungwan Park,
 * All rights reserved.
 */

package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 클래스 이름 : CarNameGenerator.java
 *
 * @author Seungwan Park, github.com/toneyparky
 * @version 1.0
 * <p>
 * 날짜 : 2019.12.5 목요일
 */
public class CarNameGenerator {
    /*
     * CarNameGenerator 클래스에서는 플레이어로부터 차량의 이름을 입력받고 각각의 차에 이름을 부여한다.
     */

    private static String inputString;
    private static List<String> carNameList;
    private static ArrayList<Car> carArrayList = new ArrayList<>();

    /**
     * 플레이어로부터 입력받은 자동차 이름을 Car 객체에 저장하는 로직을 수행하는 메서드.
     */
    public static ArrayList<Car> carNameGenerator() {
        controlNameGetting();
        saveCarName();

        return carArrayList;
    }

    /**
     * 플레이어로부터 자동차 이름을 입력받는 로직을 수행하는 메서드.
     */
    public static void controlNameGetting() {
        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            getInputString();
            separateStringToNames();
            if (checkInputStingValidation()) {
                break;
            }
            System.out.println("입력한 이름이 규칙에 맞지 않습니다. 다시 입력하세요.");
        }
    }

    /**
     * 플레이어로부터 String 타입으로 자동차 이름을 입력받는 메서드.
     */
    public static void getInputString() {
        inputString = null;
        Scanner scan = new Scanner(System.in);
        inputString = scan.nextLine();
    }

    /**
     * 플레이어로부터 입력받은 String 타입의 자동차 이름을 ,를 기준으로 잘라서 List로 만드는 메서드.
     */
    public static void separateStringToNames() {
        carNameList = Arrays.asList(inputString.split(","));
    }

    /**
     * 플레이어로부터 입력받은 자동차 이름이 유효한지 검사하는 로직을 수행하는 메서.
     */
    public static boolean checkInputStingValidation() {
        return checkCarNameIsEmpty() && checkCarNameHasBlank() && checkCarNameLength();
    }

    /**
     * 플레이어로부터 입력받은 자동차 이름이 빈 객체인지 확인하는 메서드.
     */
    public static boolean checkCarNameIsEmpty() {
        if (inputString.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * 플레이어로부터 입력받은 자동차 이름에 빈칸이 포함되어있는지 체크하는 메서드.
     */
    public static boolean checkCarNameHasBlank() {
        if (inputString.contains(" ")) {
            return false;
        }
        return true;
    }

    /**
     * 플레이어로부터 입력받은 자동차 이름이 5글자가 넘는지 확인하는 메서드.
     */
    public static boolean checkCarNameLength() {
        for (String carName : carNameList) {
            if (carName.length() > 5) {
                return false;
            }
        }
        return true;
    }

    /**
     * 플레이어로부터 입력받은 자동차 이름을 Car 객체에 저장하는 메서드.
     */
    public static void saveCarName() {
        carArrayList.clear();
        for (String name : carNameList) {
            Car car = new Car(name);
            carArrayList.add(car);
        }
    }

}
