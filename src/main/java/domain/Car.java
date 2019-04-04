package domain;

import java.util.ArrayList;

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

    public Car(String name) {
        this.name = name;
    }

    /* 자동차 이름배열을 Car배열 각각에 인스턴스 생성과 동시에 초기화 하는 메소드 */
    public static Car[] inputCarName(String[] carNameArray){

        Car[] cars = new Car[carNameArray.length];

        for(int i=0;i<carNameArray.length;i++){

            /* 분리된 이름배열을 Car배열 각각의 name에 인스턴스 생성과 동시에 name 변수 초기화 하는 반복문*/
            cars[i] = new Car(carNameArray[i]);
        }

        return cars;
    }

    /* 자동차 이름 반환 하는 메소드 */
    public String getName(){

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