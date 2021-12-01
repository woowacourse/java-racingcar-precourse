package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        String[] arrayCar = inputToArray();
        Car[] arrayCarObject = arrayCarObj(arrayCar);
    }


    private static String[] inputToArray() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String inputCarName = Console.readLine();
        String[] arrayCar = inputCarName.split(",");
        return arrayCar;
    }
    private static Car[] arrayCarObj(String[] arrayCar) {
        Car[] arrayCarObj = new Car[arrayCar.length];
        for (int i = 0; i < arrayCar.length; i++) {
            arrayCarObj[i] = new Car(arrayCar[i]);
        }
        return arrayCarObj;
    }

}
