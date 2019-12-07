package com.jenny.racing;

import domain.Car;

import java.util.Scanner;

public class Racing implements Racable{

    private Car[] cars;
    private int trial;

    @Override
    public void printNameAskMsg() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Override
    public boolean areValidNames(String input) {
        String[] names = input.split(",");

        for(String name : names){
            if(name.length() > 5){
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
        int cnt = names.length;
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
        return false;
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
        getNames();
        getTrial();
        printProcess();
        printWinner();
    }
}
