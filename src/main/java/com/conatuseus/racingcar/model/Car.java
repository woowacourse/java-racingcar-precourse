/*
 *  @(#)Car.java       2.00    2019/04/01
 *
 *  Copyright   (c) 2019 Myungki Sa.
 *  Computer Science Engineering, Java, Daejeon, Korea
 *  All rights reserved.
 */

package com.conatuseus.racingcar.model;

/**
 * Car class
 * 자동차가 랜덤 수를 생성해서 조건에 만족하면 자신의 position을 변경하도록 한다
 *
 * @version             2.00    2019년 4월 1일
 * @author              사명기
 */
public class Car {

    /* Random으로 만들 수의 Max value */
    private static final int MAX_RANDOM = 9;

    /* Random으로 만들 수의 Min value */
    private static final int MIN_RANDOM = 0;

    /* 랜덤 수가 4 이상 되야 갈 수 있음에 사용하기 위한 변수 */
    private static final int GOING_POSSIBLE = 4;

    /* 자동차 이름 */
    private final String name;

    /* 자동차 위치 */
    private int position = 0;

    /* -을 저장하기 위한 변수 */
    private String result = "";

    /* Car 생성자 */
    public Car(String name) {
        this.name = name;
    }

    /* 이름 getter */
    public String getName() {
        return this.name;
    }

    /* 위치 getter */
    public int getPosition() {
        return this.position;
    }

    /* 랜덤 수를 생성해서 위치를 이동시키는 메소드 */
    public void addRandomNumToPosition() {
        int random = (int) (Math.random() * MAX_RANDOM) + MIN_RANDOM;           // 0 - 9 사이의 수를 생성
//        AppView.outputLine(random+"");          // 랜덤 수 확인하기 위한 코드
        if (this.isGoingPossible(random)) {       // 이 랜덤 수가 갈 수 있으면 = 4 이상이면
            this.position += random;              // 위치 이동
            this.addResult(random);               // result 변수에 random 수만큼 - 더하기
        }
    }

    /* 파라미터로 랜덤 수를 받아, 4이상이면 true, 미만이면 false 반환 */
    private boolean isGoingPossible(int random) {
        return random >= GOING_POSSIBLE;
    }

    /* result에 랜덤 수 만큼 -(작대기)를 붙여주는 메소드 */
    private void addResult(int random) {
        StringBuilder sb = new StringBuilder(this.result);
        for (int i = 0; i < random; i++) {
            sb.append("-");
        }
        this.result = sb.toString();
    }

    /* 이름과 위치만큼의 -(작대기)를 출력하기 위해 toString 재정의*/
    @Override
    public String toString() {
        return this.getName() + " : " + this.result;
    }
}
