package domain;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
    }

    /**
     * 사용자로부터 자동차의 이름들을 입력받아 반환하는 메소드입니다.
     * @return 자동차의 이름을 각 원소로 하는 문자열 배열
     */
    public static String[] getCarNames() {
        String arrCarNames[];

        try {
            Scanner rd = new Scanner(System.in);
            String strCarNames = rd.nextLine();
            arrCarNames = strCarNames.split(",");
        } catch (Exception e) {
            return null;
        }
        return arrCarNames;
    }

    /**
     * 입력으로 받은 이름을 갖는 자동차의 배열을 생성하고 반환합니다.
     * @param carNames - 자동차의 이름의 배열로, 문자열의 배열입니다.
     * @return 자동차 객체의 배열을 반환합니다.
     */
    public static Car[] createArrayOfCars(String[] carNames) {
        Car cars[] = new Car[carNames.length];
        for (int i=0; i<carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
        return cars;
    }

    /**
     * 사용자로부터 경주 시도 횟수를 입력받고 반환합니다.
     * @return 경주 시도 횟수를 반환합니다.
     */
    public static int getNumOfTrials() {
        int numOfTrials;
        try {
            Scanner rd = new Scanner(System.in);
            numOfTrials = rd.nextInt();
        } catch (Exception e) {
            return -1;
        }
        return numOfTrials;
    }

    /**
     * 입력받은 자동차를 확률적으로 전진시키거나, 멈춥니다.
     * @param c - 자동차 객체의 참조변수입니다.
     * @return 확률변수 값으로 0 부터 9 사이의 값입니다.
     */
    public static int randomlyMoveCar(Car c) {
        return 5;
    }
}
