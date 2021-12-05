package view;

import domain.Car;

import java.util.Collections;
import java.util.List;

public class OutputView {

    private static String RESULT = "실행결과";
    private static String FINAL_RESULT = "최종 우승자 : ";

    public static void printNow(List<Car> cars){
        System.out.println(RESULT);
        for(Car car : cars){
            System.out.println(car.getName() + " : " + changeDistanceTohypen(car.getPosition()));
        }
    }

    public static void printEnd(final List<String> winnerList){
        System.out.println(FINAL_RESULT + changeWinnerListToString(winnerList));
    }

    private static String changeDistanceTohypen(int distance){
        return String.join("", Collections.nCopies(distance,"-"));
    }

    private static String changeWinnerListToString(List<String> winnerList){
        return String.join(",",winnerList);
    }

}
