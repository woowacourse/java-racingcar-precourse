package domain;

import java.util.Scanner;

public class User {

    private String[] carNames;
    private int numberOfTrials;

    public User() {
        input();
    }

    public void input() {
        inputValidCarNames();
        inputValidNumberOfTrials();
    }

    /**
     * 사용자가 올바른 입력을 할 때 까지
     * 검증을 반복
     */
    public void inputValidCarNames() {
        String[] carNamesArray;

        while (true) {
            carNamesArray = inputCarNames();

            if (checkValidNames(carNamesArray)) { break; }
            System.out.println("자동차 이름은 1자 이상 5자 이하로 작성해주세요.");
        }

        setCarNames(carNamesArray);
    }

    /**
     * 경주할 자동차 전체를 문자열로 입력 받음
     * 자동차 이름을 분리하여 저장
     * @return  String[]    : 분리된 name
     */
    public String[] inputCarNames() {
        String carNamesInput;
        Scanner sc = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carNamesInput = sc.nextLine();

        return inputSlicing(carNamesInput);
    }

    /**
     * 쉼표(,)로 슬라이싱
     * @param str   : 자동차 이름을 ,로 구분하여 입력한 문자열
     * @return      : 슬라이싱하여 구분된 자동차 이름
     */
    public String[] inputSlicing(String carNamesInput) {
        String[] carNameArray;

        carNamesInput = carNamesInput.replace(" ","");  // 공백 제거
        carNameArray = carNamesInput.split(",");                    // 쉼표로 구분

        return carNameArray;
    }

    /**
     * 자동차 이름은 5자 이하만 가능
     * @param slicedInput   : 슬라이싱한 name 들
     * @return  :   true : 적합, false : 부적합
     */
    public boolean checkValidNames(String[] slicedInput) {
        if (isOnlyComma(slicedInput)) { return false; }
        if (isBlankOrOverLength(slicedInput)) { return false; }
        return true;
    }

    /* 쉼표(,) 만 입력했을 경우 */
    public boolean isOnlyComma(String[] slicedInput) {
        return slicedInput.length == 0;
    }

    /* 공백이거나 5자 이상의 name 이 존재할 경우 */
    public boolean isBlankOrOverLength(String[] slicedInput) {

        for (int i = 0; i < slicedInput.length; i++) {
            if (slicedInput[i].equals("")) {        // name 이 입력되지 않은 경우
                return true;
            }
            if (slicedInput[i].length() > ConstValue.MAXIMUM_NAME_LENGTH) {
                return true;
            }
        }
        return false;
    }

    /**
     * 사용자가 숫자만 입력 할 때 까지
     * 검증을 반복
     */
    public void inputValidNumberOfTrials() {
        int validCount;
        String count;

        while (true) {
            count = inputNumberOfTrials();
            count = count.replace(" ", "");

            if (checkValidNumber(count)) { break; }
            System.out.println("올바른 숫자를 입력하세요.");
        }
        validCount = Integer.parseInt(count);
        setNumberOfTrials(validCount);
    }

    /**
     * 사용자가 몇 번을 시도할 것인지를 입력
     */
    public String inputNumberOfTrials() {
        Scanner sc = new Scanner(System.in);

        System.out.println("시도할 횟수는 몇회인가요?");
        return sc.nextLine();
    }

    /* 입력을 안했거나 숫자가 아니거나 */
    public boolean checkValidNumber(String input) {
        if (isBlankInput(input)) { return false; }
        if (!isNumber(input)) { return false; }
        return true;
    }

    public boolean isNumber(String input) {
        char c;
        for (int i = 0; i < input.length(); i++) {
            c = input.charAt(i);
            if (c < '0' || c >'9') {
                return false;
            }
        }
        return true;
    }

    public boolean isBlankInput(String input) {
        return input.equals("");
    }

    public void setCarNames(String[] carNames) {
        this.carNames = carNames;
    }

    public void setNumberOfTrials(int numberOfTrials) {
        this.numberOfTrials = numberOfTrials;
    }

    public String[] getCarNames() { return carNames; }

    public int getNumberOfTrials() { return numberOfTrials; }
}
