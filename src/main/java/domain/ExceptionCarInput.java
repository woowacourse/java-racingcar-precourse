/*
 * class: ExceptionCarInput
 *
 * version: 3.0
 *
 * date: 2019.12.08
 *
 * 이 프로그램의 저작권은 정은석에게 있습니다.
 * Copyright 2019.12.08
 */
package domain;

/**
 * 사용자에게 받은 이름에 예외처리해주는 기능
 *
 * @author joseph415
 * @version 3.0 2019.12.08
 */
public class ExceptionCarInput {
    ComparingCarName compare = new ComparingCarName();

    /**
     * 예외처리 해주는 매소드 같은이름,1~5글자 수 에대해서 예외처리
     *
     * @param carList 사용자가 입력한 자동차 이름들
     * @return 예외가 있다면 true
     */
    public boolean exceptCarInput(String[] carList) {
        for (int i = 0; i < carList.length; i++) {
            if (carList[i].length() < 1 || carList[i].length() > 5) {
                System.out.println("car이름은 1~5글자 입니다. 재입력!!!");
                return true;
            }
            if (compare.compareName(carList[i], carList, i)) {
                System.out.println("중복이름 입력 불가. 재입력!!!");
                return true;
            }
        }
        return false;
    }
}
