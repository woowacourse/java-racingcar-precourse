package com.woowa.racingcar;

import java.util.ArrayList;

public class DataReceiver {

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
}
