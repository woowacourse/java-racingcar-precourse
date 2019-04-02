package domain;

import java.util.Scanner;

public class User {

    private String[] carNames;
    private int numberOfTrials;

    public User() {
        input();
    }

    public void input() {
        inputCarNames();
        inputNumberOfTrials();
    }

    /**
     * 경주할 자동차 전체를 문자열로 입력 받음
     * 자동차 이름을 분리하여 저장
     */
    public void inputCarNames() {
        String carNamesInput;
        String[] carNamesArray;
        Scanner sc = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carNamesInput = sc.nextLine();

        carNamesArray = inputSlicing(carNamesInput);    // 자동차 이름 분리

        setCarNames(carNamesArray);
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
     * 사용자가 몇 번을 시도할 것인지를 입력
     */
    public void inputNumberOfTrials() {
        int count;
        Scanner sc = new Scanner(System.in);

        System.out.println("시도할 횟수는 몇회인가요?");
        count = sc.nextInt();

        setNumberOfTrials(count);
    }

    public void setCarNames(String[] carNames) {
        this.carNames = carNames;
    }

    public void setNumberOfTrials(int numberOfTrials) {
        this.numberOfTrials = numberOfTrials;
    }

    public String[] getCarNames() {
        return carNames;
    }

    public int getNumberOfTrials() {
        return numberOfTrials;
    }
}
