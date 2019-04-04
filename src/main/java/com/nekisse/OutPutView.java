package com.nekisse;

import com.nekisse.domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OutPutView {

    public static void showTurnResult(TurnResult turnResult) {
        Map<String, String> turnResult1 = turnResult.getTurnResult();
        for (Map.Entry<String, String> stringStringEntry : turnResult1.entrySet()) {
            System.out.println(stringStringEntry.getKey() + stringStringEntry.getValue());
        }
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printWiningCars(WiningCars winingCars) {
        List<String> winningCars= new ArrayList<>();
        for (Car car : winingCars.getWiningCars()) {
            winningCars.add(car.getCarName());
        }
        String winingCarName = String.join(",", winningCars);
        System.out.println(winingCarName + " 가 최종 우승 했습니다.");
    }
}
