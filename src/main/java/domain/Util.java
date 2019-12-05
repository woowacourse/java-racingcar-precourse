package domain;

import java.util.Arrays;

public class Util {
    private String carNameArray[];
    private Car carObjectArray[];
    private int finalCarPositions[];

    static final int MINIMUM_NAME_LENGTH = 1;
    static final int LIMIT_NAME_LENGTH = 5;
    static final int JUDGE_TO_GO = 4;

    // 쉼표를 기준으로 자동차의 이름들을 분류
    void splitCarName(String rawCarName) {
        carNameArray = rawCarName.split(",");
    }

    // 공백이 아니고 길이가 5이하인 이름만으로 구성되어있는지 검사
    boolean isNameLengthValid() {
        for (int i = 0; i < carNameArray.length; i++) {
            if ((MINIMUM_NAME_LENGTH > carNameArray[i].length())
                    || (carNameArray[i].length() > LIMIT_NAME_LENGTH)) {
                System.out.println("유효하지 않은 자동차 이름이 있습니다.");
                System.out.println("공백이 아니고 길이가 5이하인 이름을 쉼표로 구분하여 입력해주세요.");
                return false;
            }
        }
        return true;
    }

    // 각 이름별로 객체 배열 생성
    void makeCarObjects() {
        carObjectArray = new Car[carNameArray.length];
        for (int i = 0; i < carNameArray.length; i++) {
            carObjectArray[i] = new Car(carNameArray[i]);
        }
    }

    // 각 객체의 현재 전진 상태를 이름과 하이픈으로 출력
    void printStateOfCars(int index) {
        System.out.print(carObjectArray[index].getName() + " : ");
        for (int i = 0; i < carObjectArray[index].getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    // 사용자가 입력한 시도횟수 만큼 반복
    void repeatGameAndPrint(int repeatTimes) {
        while (repeatTimes != 0) {
            repeatTimes--;
            for (int i = 0; i < carObjectArray.length; i++) {
                goForwordOrStop(i);
                printStateOfCars(i);
            }
            System.out.println();
        }
    }

    // 0 ~ 9 사이의 랜덤한 정수 반환
    int generateRandomNumber() {
        return (int) (Math.random() * 10);
    }

    void goForwordOrStop(int index) {
        if (generateRandomNumber() >= JUDGE_TO_GO) {
            carObjectArray[index].addPosition();
        }
    }

    // 최종 포지션 중 최대값을 찾아 반환
    int getMaxPositions() {
        finalCarPositions = new int[carObjectArray.length];
        for (int i = 0; i < carObjectArray.length; i++) {
            finalCarPositions[i] = carObjectArray[i].getPosition();
        }
        Arrays.sort(finalCarPositions);
        return finalCarPositions[carObjectArray.length - 1];
    }
}
