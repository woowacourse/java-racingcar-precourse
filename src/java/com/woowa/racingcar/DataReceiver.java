/*
 * Class: DataReceiver.java
 * Version: 1.0
 * Date: 2019-04-02
 * Author: Kibaek Yoo
 */

package com.woowa.racingcar;

import java.util.ArrayList;
import java.util.Scanner;

public class DataReceiver {

    private static final String COMMENT_WHEN_REQUEST_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String COMMENT_WHEN_REQUEST_RUN_COUNT = "시도할 횟수는 몇회인가요?";
    private static final String COMMENT_WHEN_RUN_COUNT_NOT_PARSED = "1과 같거나 큰 정수를 입력해 주세요";

    /**
     * 유저에게 자동차이름 입력을 요청해, 조건이 맞다면, 이를 객체화 해 반환하는 함수
     *
     * @return ArrayList<Car>
     */
    public static ArrayList<Car> getCarListFromUserInput(Scanner scanner) {

        while (true) {
            System.out.println(COMMENT_WHEN_REQUEST_CAR_NAME);
            String carNameTotalString = scanner.next();

            if (ErrorChecker.checkCarStringHaveError(carNameTotalString)) {
                continue;
            }

            return makeCarList(carNameTotalString);
        }

    }

    /**
     * 자동차 이름 String으로 Car 객체를 생성해 반환하는 함수
     *
     * @param carNames 자동차이름 String
     * @return 생성된 Car객체
     */
    public static ArrayList<Car> makeCarList(String carNames) {
        ArrayList<Car> tmpCarList = new ArrayList<Car>();
        String[] carNamesArray = carNames.split(",");

        for (int i = 0; i < carNamesArray.length; i++) {
            tmpCarList.add(new Car(carNamesArray[i]));
        }

        return tmpCarList;
    }

    /**
     * 1. 유저에게 라운드횟수 입력 요청
     * 2. 조건검사(int로 변환불가시 1로 돌아감)
     * 3. 반환
     *
     * @return runCount
     */
    public static int getRunCountFromUserInput(Scanner scanner) {

        while (true) {
            System.out.println(COMMENT_WHEN_REQUEST_RUN_COUNT);
            String inputString = scanner.next();

            if (ErrorChecker.checkRunCountStringHasError(inputString)) {
                return Integer.parseInt(inputString);
            }
            System.out.println(COMMENT_WHEN_RUN_COUNT_NOT_PARSED);
        }
    }
}
