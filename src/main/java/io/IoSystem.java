package io;

import domain.Car;
import java.util.Scanner;
import java.util.ArrayList;

class IoSystem {
    private Scanner sc;
    private int count;

    IoSystem() {
        sc = new Scanner(System.in);
    }

    public void printCarList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public String inputCarList() {
        return sc.nextLine();
    }

    public void inputCount() {
        this.count = sc.nextInt();
    }

    public void printResult(){
        System.out.println("실행결과");
    }
    
    public int getRandomInt(){
        return (int)(Math.random() * 10);
    }

    public void printResultCars(ArrayList<Car> Cars){
        if(Cars.size() > 1){
            for(int i = 0 ; i< Cars.size() -1 ;i++){
                System.out.print(Cars.indexOf(i).getName());
                System.out.print(", ");
            }
        }
        for(int i = Cars.size()-1 ;i<Cars.size();i++){
            System.out.print(Cars.indexOf(i).getName());
        }
        System.out.println("가 최종 우승했습니다.");
    }
}