/*
 * 클래스 이름: Input.java
 * 버전 정보: 1.0.0
 * 날짜: 2019/04/03
 * Copyright 2019 Inkwon Lee
 */
package domain;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 사용자가 입력하는 부분을 담당하는 클래스
 * 자동차 이름 등록과 시도 횟수를 입력하는 함수 구현
 */
public class Input {
    private Scanner scanner;

    private Input() {
        scanner = new Scanner(System.in);
    }

    private static class InputHolder {
        public static final Input INSTANCE = new Input();
    }

    public static Input getInstance() {
        return InputHolder.INSTANCE;
    }

    public ArrayList<Car> enrollCarName() {
        ArrayList<Car> carList = new ArrayList<>();
        String input;
        String[] inputCarName;

        while (true) {
            input = scanner.nextLine();
            inputCarName = input.split(",");

            if (!InputException.getInstance().enrollCarNullName(inputCarName) || !InputException.getInstance().enrollCarOneName(inputCarName)
                    || !InputException.getInstance().enrollCarOverLength(inputCarName) || !InputException.getInstance().enrollCarBlankName(inputCarName)
                    || !InputException.getInstance().enrollCarOverlapName(inputCarName) || !InputException.getInstance().enrollCarLastComma(input)) {
                continue;
            }

            for (String name : inputCarName) {
                carList.add(new Car(name));
            }
            return carList;
        }
    }

    public int tryNumber() {
        String inputNumber;
        int tryNumber;

        while (true) {
            inputNumber = scanner.nextLine();
            if (!InputException.getInstance().tryNumberBlank(inputNumber)) {
                continue;
            }
            try {
                tryNumber = Integer.parseInt(inputNumber);
                scanner.close();
                return tryNumber;
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.ERROR_OTHER_TRY_NUMBER.getMessage());
            }
        }
    }

}
