/*
 * Racing.java
 *
 * 1.8
 *
 * 2019/12/07
 *
 * Copyright (c) 2019 Janghee Lee
 * All rights reserved.
 * */

package com.jenny.racing;

import domain.Car;

import java.util.Scanner;

/*
 * 기능에 필요한 모든 함수가 들어있는 클래스
 */

public class Racing implements Racable{

    private Car[] cars;
    private int trial;
    private int cnt;

    @Override
    public void printNameAskMsg() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Override
    public boolean areValidNames(String input) {
        String[] names = input.split(",");

        for(String name : names){
            if(name.length() > 5 || name.equals("")){
                System.out.println("5자 이하의 이름만 가능합니다. 다시 입력해주십시오.");
                return false;
            }
        }
        return true;
    }

    @Override
    public void getNames() {
        Scanner sc = new Scanner(System.in);
        while(true){
            printNameAskMsg();
            String input =  sc.nextLine();
            if(areValidNames(input)){
                createCars(input.split(","));
                break;
            }
        }
    }

    @Override
    public void createCars(String[] names) {
        cnt = names.length;
        cars = new Car[cnt];

        for(int idx = 0; idx < cnt; idx++){
            cars[idx] = new Car(names[idx]);
        }
    }

    @Override
    public void printTrialAskMsg() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    @Override
    public boolean isValidTrial(String trial) {
        int len = trial.length();

        for(int idx = 0; idx < len; idx++){
            char chr = trial.charAt(idx);
            if(chr < '0' || chr > '9'){
                System.out.println("숫자만 입력해 주십시오.");
                return false;
            }
        }
        return true;
    }

    @Override
    public void getTrial() {
        Scanner sc = new Scanner(System.in);

        while(true){
            printTrialAskMsg();
            String input = sc.nextLine();
            if(isValidTrial(input)){
                trial = Integer.parseInt(input);
                break;
            }
        }
    }

    @Override
    public boolean doesGoOrStop() {
        int random = (int)(Math.random()*10);
        if(random >= 4){
            return true;
        }
        return false;
    }

    @Override
    public void printCarPosition(int num) {
        StringBuilder dist = new StringBuilder();
        int position = cars[num].getPosition();

        for(int idx = 0; idx < position; idx++){
            dist.append("-");
        }

        System.out.println(cars[num].getName() + " : " + dist);
    }

    @Override
    public void printWinner() {
        int max = 0;
        StringBuilder nameList = new StringBuilder();

        /* 가장 멀리간 자동차의 이름을 얻어낸다 */
        for(int idx = 0; idx < cnt; idx++){
            int position = cars[idx].getPosition();
            String name = cars[idx].getName();

            if(position > max){
                max = position;
                nameList = new StringBuilder(name + ", ");
            }else if(position == max){
                nameList.append(name + ", ");
            }
        }

        /* 마지막 컴마 제거 후 출력 */
        System.out.println(nameList.substring(0, nameList.length()-2) + "가 최종 우승했습니다.");
    }

    @Override
    public void race() {
        /* 라운드 진행 */
        for(int round = 0; round < trial; round++){
            for(int carIdx = 0; carIdx < cnt; carIdx++){
                if(doesGoOrStop()){
                    cars[carIdx].go();
                }
                printCarPosition(carIdx);
            }
            System.out.println();
        }
    }

    @Override
    public void run() {
        getNames();
        getTrial();
        race();
        printWinner();
    }
}
