package com.conatuseus.racingcar.appcontroller;

import com.conatuseus.racingcar.appview.AppView;
import com.conatuseus.racingcar.model.Car;

import java.util.ArrayList;

public class AppController {

    public static ArrayList<Car> carList=new ArrayList<>();

    public AppController(){
    }


    public void run(){
        AppView.outputLine(">> 게임을 시작합니다.");

        this.inputAndMakeCarList();
//        for(Car car : carList){
//            AppView.outputLine(car.getName());
//        }

        AppView.outputLine("<< 게임을 종료합니다.");
    }

    private void inputAndMakeCarList(){
        String[] carsName=AppView.inputNameOfCar();

        for(String name : carsName){
            carList.add(new Car(name));
        }
    }

}
