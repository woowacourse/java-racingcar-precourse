package domain;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Car 클래스는 자동차 게임에 관련된 모든 상태를 나타내는 클래스 입니다.
 *
 * @version 2019년 3월 30일
 * @author 이중혁
 */

public class Car {

    private final String name;
    private int position = 0;
    protected ArrayList<String> carResult = new ArrayList<String>();           // 진행도를 입력받는 ArrayList
    protected ArrayList<String> firstCarName = new ArrayList<String>();   // 1등 자동차 이름 저장 ArrayList
    private static final int ALLOW_NAME_LENGTH = 5;                       // 이름 최대 허용범위

    public Car(String name) {
        this.name = name;
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
    public static String[] divideCarName(Car car) {

        String[] carNameArray = car.name.split(",");                // (,)를 기준으로 분리 하여 배열저장

        return carNameArray;
    }

    /* 자동차 이름배열을 Car배열 각각에 인스턴스 생성과 동시에 초기화 하는 메소드 */
    public Car[] inputCarName(String[] carNameArray){

        Car[] cars = new Car[carNameArray.length];

        for(int i=0;i<carNameArray.length;i++){

            /* 분리된 이름배열을 Car배열 각각의 name에 인스턴스 생성과 동시에 name 변수 초기화 하는 반복문*/
            cars[i] = new Car(carNameArray[i]);
        }

        return cars;
    }

    /* 자동차 이름 반환 하는 메소드 */
    public String getName(Car car){

        return this.name;
    }

    /* 자동차 위치 반환 하는 메소드 */
    public int getPosition(){

        return this.position;
    }

    /* 자동차 위치 증가 시키는 메소드 */
    public void increasePosition(){

        this.position++;
    }

}