package racingcar;

public class InputValidator {
    static final int CAR_NAME_SIZE_CONDITION = 5;

    public boolean validateCarName(String[] cars) {
        InputValidator inputValidator = new InputValidator();
        for (String carName : cars) {
            if (!inputValidator.isNameValid(carName)) {
                System.out.println("[ERROR] 자동차 이름은 5자 이하만 가능하다.");
            }
        }
        return true;
    }

    public boolean validGameCntInput(String cntInput) {
        for (int i = 0; i < cntInput.length(); i++) {
            if (!Character.isDigit(cntInput.charAt(i))) {
                System.out.println("[ERROR] 시도횟수는 숫자여야 한다.");
                return false;
            }
        }
        return true;
    }

    private boolean isNameValid(String carName) {
        if (carName.length() > CAR_NAME_SIZE_CONDITION)
            return false;
        return true;
    }
}
