/*
 * 클래스 이름: InputException.java
 * 버전 정보: 1.0.0
 * 날짜: 2019/04/03
 * Copyright 2019 Inkwon Lee
 */
package domain;

/*
 * 사용자가 입력하는 부분을 예외처리 하는 클래스
 * 이름 중복확인 함수, 이름 길이가 5이상인지 확인하는 함수,
 * 이름에 공백이 있는지 확인하는 함수, 이름의 개수가 1개인지 확인하는 함수
 * 이름을 안쳤는지 확인하는 함수, 마지막에 콤마가 들어갔는지 확인하는 함수
 * 시도횟수에서 숫자말고 다른 문자가 왔는지 확인하는함수 구현
 */
public class InputException {

    private InputException() {
    }

    private static class InputExceptionHolder {
        public static final InputException INSTANCE = new InputException();
    }

    public static InputException getInstance() {
        return InputExceptionHolder.INSTANCE;
    }

    public boolean enrollCarOverlapName(String[] inputCarName) {
        for (int i = 0; i < inputCarName.length; i++) {
            String compareName = inputCarName[i];
            if (!checkOverlapName(compareName, inputCarName, i)) {
                return false;
            }
        }
        return true;
    }

    // 선택된 이름이 같은게 있는지 없는지 판별
    private boolean checkOverlapName(String compareName, String[] inputCarName, int i) {
        for (int j = 0; j < i; j++) {
            if (compareName.equals(inputCarName[j])) {
                System.out.println(ErrorMessage.ERROR_OVERLAP_NAME.getMessage());
                return false;
            }
        }
        return true;
    }

    public boolean enrollCarOverLength(String[] inputCarName) {
        for (String name : inputCarName) {
            if (name.length() > 5) {
                System.out.println(ErrorMessage.ERROR_OVER_LENGTH.getMessage());
                return false;
            }
        }
        return true;
    }

    public boolean enrollCarBlankName(String[] inputCarName) {
        for (String name : inputCarName) {
            if (name.length() != name.replaceAll(" ", "").length() || "".equals(name)) {
                System.out.println(ErrorMessage.ERROR_BLANK_NAME.getMessage());
                return false;
            }
        }
        return true;
    }

    public boolean enrollCarOneName(String[] inputCarName) {
        if (inputCarName.length == 1) {
            System.out.println(ErrorMessage.ERROR_ONE_NAME.getMessage());
            return false;
        }
        return true;
    }

    public boolean enrollCarNullName(String[] inputCarName) {
        if (inputCarName.length == 0 || (inputCarName.length == 1 && "".equals(inputCarName[0].trim()))) {
            System.out.println(ErrorMessage.ERROR_NULL_NAME.getMessage());
            return false;
        }
        return true;
    }

    public boolean enrollCarLastComma(String input) {
        if (input.substring(input.length() - 1).equals(",")) {
            System.out.println(ErrorMessage.ERROR_HAVE_LAST_COMMA.getMessage());
            return false;
        }
        return true;
    }

    public boolean tryNumberBlank(String inputNumber) {
        if ("".equals(inputNumber.trim())) {
            System.out.println(ErrorMessage.ERROR_BLANK_TRY_NUMBER.getMessage());
            return false;
        }
        return true;
    }

}
