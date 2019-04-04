package domain;

import java.util.Scanner;

/**
 * 사용자가 car 객체의 이름과
 * 시행 횟수를 입력하는 class
 * 사용자의 입력을 검증한다.
 *
 * @author 강연욱
 */
public class User {

    private String[] carNames;
    private int numberOfTrials;

    public User() {
        callInputFunctions();
    }

    private void callInputFunctions() {
        inputValidCarNames();
        inputValidNumberOfTrials();
    }

    /**
     * 사용자가 올바른 name 입력을 할 때 까지 검증을 반복
     * 유효한 name 을 field 에 세팅
     */
    private void inputValidCarNames() {
        String[] carNamesArray;

        while (true) {
            carNamesArray = inputStringCarNames();

            if (checkValidNames(carNamesArray)) {
                break;
            }
            System.out.println("자동차 이름은 1자 이상 5자 이하로 작성해주세요.");
        }
        setCarNames(carNamesArray);
    }

    /**
     * 경주할 자동차 전체를 문자열로 입력 받음
     * 자동차 이름을 분리하여 저장
     *
     * @return String[]    : 분리된 name
     */
    private String[] inputStringCarNames() {
        String carNamesInput;
        Scanner sc = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carNamesInput = sc.nextLine();

        return sliceInput(carNamesInput);
    }

    /**
     * 쉼표(,)로 슬라이싱
     *
     * @param str : 자동차 이름을 ,로 구분하여 입력한 문자열
     * @return : 슬라이싱하여 구분된 자동차 이름
     */
    private String[] sliceInput(String carNamesInput) {
        String[] carNameArray;

        carNamesInput = carNamesInput.replace(" ", "");
        carNameArray = carNamesInput.split(",");

        return carNameArray;
    }

    /**
     * 자동차 이름은 5자 이하만 가능
     *
     * @param slicedInput : 슬라이싱한 name 들
     * @return :   true : 적합, false : 부적합
     */
    private boolean checkValidNames(String[] slicedInput) {
        return (!isOnlyComma(slicedInput))
                && (!isBlankOrOverLength(slicedInput));
    }

    private boolean isOnlyComma(String[] slicedInput) {
        return slicedInput.length == 0;
    }

    private boolean isBlankOrOverLength(String[] slicedInput) {

        for (int i = 0; i < slicedInput.length; i++) {
            if (slicedInput[i].equals("")
                    || (slicedInput[i].length() > ConstValue.MAXIMUM_NAME_LENGTH))
                return true;
        }
        return false;
    }

    private void inputValidNumberOfTrials() {
        int validCount;
        String count;

        while (true) {
            count = inputNumberOfTrials();
            count = count.replace(" ", "");

            if (checkValidNumber(count)) {
                break;
            }
            System.out.println("올바른 숫자를 입력하세요.");
        }
        validCount = Integer.parseInt(count);
        setNumberOfTrials(validCount);
    }

    private String inputNumberOfTrials() {
        Scanner sc = new Scanner(System.in);

        System.out.println("시도할 횟수는 몇회인가요?");
        return sc.nextLine();
    }

    private boolean checkValidNumber(String input) {
        return (!isBlankInput(input))
                && (isNumber(input));
    }

    private boolean isNumber(String input) {
        char c;
        for (int i = 0; i < input.length(); i++) {
            c = input.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    private boolean isBlankInput(String input) {
        return input.equals("");
    }

    private void setCarNames(String[] carNames) {
        this.carNames = carNames;
    }

    private void setNumberOfTrials(int numberOfTrials) {
        this.numberOfTrials = numberOfTrials;
    }

    public String[] getCarNames() {
        return carNames;
    }

    public int getNumberOfTrials() {
        return numberOfTrials;
    }
}
