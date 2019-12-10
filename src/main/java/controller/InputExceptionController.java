/*
 * Copyright (c) 2019 by SorinJin
 * All rights reserved.
 *
 * InputExceptionController.java
 * 입력된 데이터를 검증하는 클래스
 *
 * @author      Sorin Jin
 * @version     1.0
 * @date        09 Dec 2019
 *
 * 필요 이상의 객체가 생성되면 메모리가 낭비되기 때문에
 * 본 클래스는 Singleton 패턴으로 작성하였습니다.
 *
 */

package controller;

import java.util.HashSet;
import domain.Message;

public class InputExceptionController {

    final static int MiN_COUNT_OF_CAR = 2;
    final static int LENGTH_OF_NAME = 5;
    final static int ZERO = 0;

    private InputExceptionController() {}

    private static class InnerInstanceClass {
        private static final InputExceptionController instance = new InputExceptionController();
    }

    public static InputExceptionController getInstance() {
        return InnerInstanceClass.instance;
    }

    public boolean validateCarName(String[] input) {
        if((checkCountOfCar(input)) && (checkLengthOfName(input)) && (checkDuplicationOfName(input))) {
            return true;
        }
        return false;
    }

    /* 자동차가 1대 이하인 경우 */
    private boolean checkCountOfCar(String[] cars) {
        if(cars.length < MiN_COUNT_OF_CAR) {
            System.out.println(Message.INPUT_CAR_COUNT_ERROR.getMessage());
            return false;
        }
        return true;
    }

    /* 이름이 6자 이상인 경우 */
    private boolean checkLengthOfName(String[] cars) {
        for (String name : cars) {
            if ((name.length() > LENGTH_OF_NAME) || (name.length() == ZERO )) {
                System.out.println(Message.INPUT_NAME_LENGTH_ERROR.getMessage());
                return false;
            }
        }
        return true;
    }

    /* 중복된 이름이 있을 경우 */
    private boolean checkDuplicationOfName(String[] input) {
        HashSet<String> inputHashSet = new HashSet<>();
        for (String name : input) {
            inputHashSet.add(name);
        }
        if (inputHashSet.size() == input.length) {
            return true;
        }
        System.out.println(Message.INPUT_DUPLICATION_ERROR.getMessage());
        return false;
    }

}
