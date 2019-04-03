package domain;

import java.util.ArrayList;

public class ResultPrinter {
    private ArrayList<Car> carList;

    ResultPrinter(ArrayList<Car> carList) {
        this.carList = carList;
    }

    public void PrintAllResults(int raceAttempt) {
        for (int i = 0; i < raceAttempt; i++) {
            PrintEachRaceAttemptResult();
        }
    }

    private void PrintEachRaceAttemptResult(){
        for(int carOrder = 0; carOrder < carList.size(); carOrder++){
            PrintEachCarResult(carOrder);
        }
    }

    private void PrintEachCarResult(int carOrder){
        System.out.println("이후 구현 예정");
    }
}
