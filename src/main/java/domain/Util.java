package domain;

public class Util {
    static String carNameArray[];
    static Car carObjectArray[];

    static final int MINIMUM_NAME_LENGTH = 1;
    static final int LIMIT_NAME_LENGTH = 5;

    // 쉼표를 기준으로 자동차의 이름들을 분류
   static void splitCarName(String rawCarName) {
        carNameArray = rawCarName.split(",");
    }

    // 공백이 아니고 길이가 5이하인 이름만으로 구성되어있는지 검사
    static boolean isNameLengthValid() {
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
    static void makeCarObjects() {
        carObjectArray = new Car[carNameArray.length];
        for (int i = 0; i < carNameArray.length; i++) {
            carObjectArray[i] = new Car(carNameArray[i]);
        }
    }
}
