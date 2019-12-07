/*
 * Racable.java
 *
 * 1.8
 *
 * 2019/12/07
 *
 * Copyright (c) 2019 Janghee Lee
 * All rights reserved.
 * */

package com.jenny.racing;

/*
 * Racable 인터페이스
 * 필요한 모든 기능을 선언함
 */

public interface Racable {

    // 1-1. 경주할 자동차의 이름을 입력하라는 문구를 띄움
    void printNameAskMsg();

    // 1-2. 입력받은 이름이 유효한지 검사하는 함수
    boolean areValidNames(String names);

    // 1-3. 자동차의 이름을 입력받는 함수
    void getNames();

    // 1-4. 입력받은 유효한 이름으로 Car 인스턴스들을 생성하는 함수
    void createCars(String[] names);

    // 2-1. 시도할 횟수를 입력하라는 문구를 띄움
    void printTrialAskMsg();

    // 2-2. 입력된 시도횟수가 유효한지 검사하는 함수
    boolean isValidTrial(String trial);

    // 2-3. 이동횟수를 입력받는 함수
    void getTrial();

    // 3-1. 랜덤수 발생시켜 전진 혹은 정지를 결정하는 함수
    boolean doesGoOrStop();

    // 3-2. 자동차의 이름별 이동거리를 띄울 함수
    void printCarPosition(int num);

    // 3-3. 우승자를 띄울 함수
    void printWinner();

    // 3-4. 본격적인 레이싱을 수행하는 함수
    void race();

    // 3-5. 전체 수행
    void run();

}
