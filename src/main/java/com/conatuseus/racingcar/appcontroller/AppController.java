package com.conatuseus.racingcar.appcontroller;

import com.conatuseus.racingcar.appview.AppView;
import com.conatuseus.racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class AppController {

    public static List<Car> carList=new ArrayList<>();
    private int numberOfTry;
    private int maxPosition;

    private int getNumberOfTry() {
        return numberOfTry;
    }

    private void setNumberOfTry(int numberOfTry) {
        this.numberOfTry = numberOfTry;
    }

    public int getMaxPosition() {
        return maxPosition;
    }

    private void setMaxPosition(int maxPosition) {
        this.maxPosition = maxPosition;
    }

    public AppController(){
        this.setMaxPosition(0);
    }

    public void run(){
        AppView.outputLine(">> 게임을 시작합니다.");

        this.inputAndMakeCarList();
        this.setNumberOfTry(AppView.inputNumberOfTry());

        AppView.outputLine("실행결과");
        racingNumberOfTry(this.getNumberOfTry());
        this.printWinner(this.getMaxPosition());

        AppView.outputLine("<< 게임을 종료합니다.");
    }

    private void inputAndMakeCarList(){
        String[] carsName = AppView.inputNameOfCar();

        for(String name : carsName){
            carList.add(new Car(name));
        }
    }

    private void racingOneStep(int step){
        for(Car car : carList){
            car.addRandomNumToPosition();
//            AppView.outputLine(car.getPosition()+"");   // position과 - 이 맞는지 보기위한 코드
            AppView.outputLine(car.toString());
            if(step == this.getNumberOfTry()-1){
                this.setMaxPosition(Integer.max(maxPosition,car.getPosition()));      // 마지막 Step이면 maxPosition 검사해서 저장
            }
        }
    }

    private void racingNumberOfTry(int numberOfTry){
        for(int step=0; step<numberOfTry; step++){
            racingOneStep(step);
            AppView.outputLine("");
        }
    }

    private void printWinner(int maxPosition){
        for(Car car: carList){
            if(car.getPosition() == maxPosition){
                AppView.output(car.getName()+" ");
            }
        }
        AppView.outputLine("가 최종 우승했습니다.");
    }
}
