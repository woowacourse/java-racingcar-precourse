package domain;

import service.NamingService;

import java.util.Random;

/**
 * 경주에 쓰일 자동차
 *
 * @version 1.0(2019.04.01)
 * @author  김종윤
 */
public class Car {
    /*
     * 구현 기능
     * 1.움직인 위치 표시
     * 2.랜덤 수 생성(0~9)
     * 3.움질일 수 있는지 확인
     * 4.자동차 움직이기
     */

    /**움직일 수 있는 기준 값*/
    private final static int REFERENCE_VALUE_OF_MOVING = 4;
    private final String name;
    private int position = 0;

    public Car(String name) {
        //자동차 오브젝트를 생성하기 앞서 이름이 5글자 이상인지 확인하고 다시 입력받기
        this.name = new NamingService().checkReNamingCar(name);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    /**
    * 현재 움직인 거리(position)을 시각적으로 보여주기
    */
    public void printPosition(){
        for(int i = 0; i < position; i++){
            System.out.print("-");
        }
        System.out.print("\n");
    }

    private int createRandomNumber(){
        Random r = new Random();
        int randomNum = r.nextInt(10);
        return randomNum;
    }

    private boolean checkPossibleMoving(){
        int randomNumber = createRandomNumber();
        if(randomNumber < REFERENCE_VALUE_OF_MOVING){
            return false;
        }
        return true;
    }

    public void moveCar(){
        if(checkPossibleMoving()){
            position += 1;
        }
    }

}
