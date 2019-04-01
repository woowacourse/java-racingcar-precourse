/*
 *  @(#)AppController.java       2.00    2019/04/01
 *
 *  Copyright   (c) 2019 Myungki Sa.
 *  Computer Science Engineering, Java, Daejeon, Korea
 *  All rights reserved.
 */

package com.conatuseus.racingcar.appcontroller;

import com.conatuseus.racingcar.appview.AppView;
import com.conatuseus.racingcar.model.Car;
import java.util.ArrayList;
import java.util.List;

/**
 * MCV 패턴에서 Controller에 해당하는 클래스
 * AppView 클래스와 Car클래스와 연결되서 많은 작업을 한다.
 * 자동차 이름을 입력받는 메소드, 레이싱을 1회 수행하는 메소드
 * 레이싱을 시도할 횟수만큼 수행하는 메소드, 우승자를 찾아 출력하는 메소드
 * 위의 메소드를 사용해 실행 로직을 담당하는 메소드가 있다.
 *
 * @version             2.00    2019년 4월 1일
 * @author              사명기
 */
public class AppController {

    /* Car객체들을 저장하기 위한 List */
    public static List<Car> carList = new ArrayList<>();

    /* 시도할 횟수를 저장할 변수 */
    private int numberOfTry;

    /* 우승자의 position을 저장할 변수 */
    private int maxPosition=0;

    /* 마지막 레이싱 회차를 저장할 변수 */
    private int lastRacingNumber;


    /* numberOfTry(시도할 횟수)의 getter */
    private int getNumberOfTry() {
        return numberOfTry;
    }

    /* numberOfTry(시도할 횟수)의 setter */
    private void setNumberOfTry(int numberOfTry) {
        this.numberOfTry = numberOfTry;
    }

    /* maxPosition(가장 큰 position)의 getter */
    private int getMaxPosition() {
        return maxPosition;
    }

    /* maxPosition(가장 큰 position)의 setter */
    private void setMaxPosition(int maxPosition) {
        this.maxPosition = maxPosition;
    }

    /* 마지막 회차 변수의 getter */
    private int getLastRacingNumber() {
        return lastRacingNumber;
    }

    /* 마지막 회차 변수의 setter */
    private void setLastRacingNumber(int lastRacingNumber) {
        this.lastRacingNumber = lastRacingNumber;
    }

    /* AppController class의 생성자.  */
    public AppController() {
    }

    /*
    * run 메소드는 게임을 순차적으로 실행하기 위한 메소드
    * 자동차 이름 입력, 시도할 횟수 입력, 실행 결과  를 순차적으로 실행한다.
    */
    public void run() {
        AppView.outputLine(">> 게임을 시작합니다.");

        this.inputNameAndMakeCarList();                         //  자동차 이름 입력받는 메소드 실행
        this.setNumberOfTry(AppView.inputNumberOfTry());        //  시도할 횟수 입력받는 메소드 실행
        this.setLastRacingNumber(this.getNumberOfTry()-1);      //  마지막 회차 저장

        AppView.outputLine("실행결과");
        racingNumberOfTry(this.getNumberOfTry());               //  시도할 횟수만큼 racing 진행 메소드 실행
        this.printWinner(this.getMaxPosition());                //  우승한 자동차 이름 출력하는 메소드 실행

        AppView.outputLine("<< 게임을 종료합니다.");
    }

    /**
    * 자동차의 이름을 입력받아 자동차 객체를 생성해 List에 넣는 메소드
    * AppView클래스의 이름 입력받는 메소드를 실행해 자동차 이름의 배열을 가져옴
    * 가져온 자동차 이름들로 자동차 객체를 생성해서 List에 넣음
    */
    private void inputNameAndMakeCarList() {
        String[] carsName = AppView.inputNameOfCar();       // AppView class의 메소드를 통해 자동차 이름 배열을 받아옴

        for (String name : carsName) {
            carList.add(new Car(name));             // 배열을 돌면서 이름으로 객체 생성, 그 객체를 List에 추가
        }
    }

    /**
     * 자동차 레이싱을 1회(시도할 횟수 중) 실행하는 메소드
     * Car List의 자동차 객체마다 랜덤 숫자를 생성해 position을 변경하는 메소드를 실행
     * 그리고 position(-)를 출력한다.
     * 시도할 횟수 중 마지막 횟수에는 가장 큰 Position을 저장한다.
     * @param step
     */
    private void racingOnce(int step) {
        for (Car car : carList) {
            car.addRandomNumToPosition();                 // 자동차가 랜덤 수를 생성해 Position을 변경한다.
//            AppView.outputLine(car.getPosition()+"");   // position과 - 이 맞는지 보기위한 코드
            AppView.outputLine(car.toString());
            if (step == this.getLastRacingNumber()) {
                this.setMaxPosition(Integer.max(this.getMaxPosition(), car.getPosition()));      // 마지막 Racing이면 maxPosition 검사해서 저장
            }
        }
    }

    /**
     * 시도할 횟수만큼 레이싱을 실행하는 메소드
     * @param numberOfTry 시도할 횟수가 파라미터로 들어간다
     */
    private void racingNumberOfTry(int numberOfTry) {
        for (int step = 0; step < numberOfTry; step++) {        // 시도할 횟수만큼 실행
            racingOnce(step);
            AppView.outputLine("");
        }
    }

    /**
     * 우승자를 출력하기 위한 메소드
     * 자동차 List를 돌면서 max Position과 같으면 출력하도록 했다.
     * 바로 출력하지말고 winner List를 만들어서 출력하는게 더 좋을지가 궁금하다
     *
     * @param maxPosition 마지막 레이싱에서 저장된 max position이 파라미터로 들어간다
     */
    private void printWinner(int maxPosition) {
        for (Car car : carList) {                               //자동차 리스트를 돌며
            if (car.getPosition() == maxPosition) {             // maxPosition과 같으면
                AppView.output(car.getName() + " ");    // 자동차 이름 출력
            }
        }
        AppView.outputLine("가 최종 우승했습니다.");
    }
}
