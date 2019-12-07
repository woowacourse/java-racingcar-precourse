package com.jenny.racing;

import domain.Car;

public class Racing implements Racable{

    private Car[] cars;
    private int trial;

    @Override
    public void printNameAskMsg() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Override
    public boolean areValidNames(String names) {
        return false;
    }

    @Override
    public void getNames() {

    }

    @Override
    public void createCars(String[] names) {

    }

    @Override
    public void printTrialAskMsg() {

    }

    @Override
    public boolean isValidTrial(String trial) {
        return false;
    }

    @Override
    public void getTrial() {

    }

    @Override
    public boolean doesGoOrStop() {
        return false;
    }

    @Override
    public void printCarPosition(int num) {

    }

    @Override
    public void printProcess() {

    }

    @Override
    public void printWinner() {

    }

    @Override
    public void run() {

    }
}
