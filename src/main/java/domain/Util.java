package domain;

public class Util {
    private String carNameArray[];
    private Car carObjectArray[];

    static final int MINIMUM_NAME_LENGTH = 1;
    static final int LIMIT_NAME_LENGTH = 5;

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
                // 포지션 연산
                printStateOfCars(i);
            }
            System.out.println();
        }
    }
}
