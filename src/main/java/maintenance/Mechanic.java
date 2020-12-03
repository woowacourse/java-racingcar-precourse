package maintenance;

import enums.ErrorMessage;
import enums.GameProcess;
import racingcar.Car;

import java.util.List;

/**
 *  자동차 이름이 유효한지 정비하고 적절한 이름을 부여한다.
 *  정비한 내용을 알린다.
 */
public class Mechanic {

    public int countNumberOfNamesWithForeAndAftBlank(String nameOfCar) {
        if (isStartsWithBlank(nameOfCar) || isEndsWithBlank(nameOfCar)) {
            return 1;
        }
        return 0;
    }

    public int countNumberOfNamesOverMaxLength(String nameOfCar) {
        if (isNameLengthOverMax(nameOfCar)) {
            return 1;
        }
        return 0;
    }

    private boolean isStartsWithBlank(String nameOfCar) {
        return nameOfCar.startsWith(" ");
    }

    private boolean isEndsWithBlank(String nameOfCar) {
        return nameOfCar.endsWith(" ");
    }

    public Car getCarWithValidName(String nameOfCar) {
        nameOfCar = shortenNameLengthToMax(nameOfCar.trim());
        if (isNameBlank(nameOfCar)) {
            return null;
        }
        return new Car(nameOfCar);
    }

    public String shortenNameLengthToMax(String nameOfCar) {
        if (isNameLengthOverMax(nameOfCar)) {
            return nameOfCar.substring(0, GameProcess.MAXIMUM_NAME_LENGTH.getValue());
        }
        return nameOfCar;
    }

    private boolean isNameLengthOverMax(String nameOfCar) {
        return nameOfCar.length() > GameProcess.MAXIMUM_NAME_LENGTH.getValue();
    }

    private boolean isNameBlank(String nameOfCar) {
        return nameOfCar.equals("");
    }

    public void noticeShortenName(int numberOfNamesOverMaxLength) {
        if (numberOfNamesOverMaxLength > 0) {
            System.err.println(ErrorMessage.OVER_MAXIMUM_NAME_LENGTH.getMessage());
        }
    }

    public void noticeNameTrimmed(int numberOfTrimmedNames) {
        if (numberOfTrimmedNames > 0) {
            System.err.println(ErrorMessage.NAME_WITH_FORE_AND_AFT_BLANK.getMessage());
        }
    }

    public void noticeBlankNameRemoved(String[] namesOfCarsArray, List<Car> carList) {
        if (isBlankNameInputted(namesOfCarsArray, carList)) {
            System.err.println(ErrorMessage.BLANK_NAME.getMessage());
        }
    }

    private boolean isBlankNameInputted(String[] namesOfCarsArray, List<Car> carList) {
        return namesOfCarsArray.length != carList.size();
    }
}
