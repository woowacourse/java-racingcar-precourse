package domain;

import java.util.Scanner;

public class RacingGame {

    private static final int ALLOW_NAME_LENGTH = 5;                       // 이름 최대 허용범위

    public static void main(String[] args){

        String carName = getCarName();
        Car[] racingCar = Car.inputCarName(divideCarName(carName));
        DuringRace runningRace = new DuringRace();

        runningRace.runRacingGame(racingCar);
    }

    /* 자동차 이름을 입력 받는 메소드 */
    public static String getCarName() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        Scanner saveCarName = new Scanner(System.in);
        String carName = saveCarName.nextLine();

        while(!separateCarNameState(carName)){

            /* 입력받은 이름이 요구 조건(차이름은 5자이하)에 만족하지 않을경우 */
            carName = saveCarName.nextLine();
        }

        return carName;
    }

    /* (,) 를 기준으로 단어를 나눴을때 5자 이내 조건을 만족하는지 확인 하는 메소드 */
    public static boolean separateCarNameState(String carName) {

        String[] carNameArray = carName.split(",");                 //매개변수를 (,)기준으로 구분후에 배열저장
        boolean carNameState = true;

        for (int i = 0; i < carNameArray.length; i++) {

            /*분리된 자동차 이름 배열 모두 확인 하기 위한 반복문*/
            if (carNameArray[i].length() > ALLOW_NAME_LENGTH) {

                /*자동차 이름이 5자 초과일경우 */
                System.out.println("자동차 이름은 5자 이하 까지만 허용합니다");
                carNameState = false;                                       // 자동차 이름 생성 불가
                break;
            }
        }
        return carNameState;
    }

    /*(,)를 기준으로 자동차 이름을 구분 하는 메소드*/
    public static String[] divideCarName(String carName) {

        String[] carNameArray = carName.split(",");                // (,)를 기준으로 분리 하여 배열저장

        return carNameArray;
    }
}
