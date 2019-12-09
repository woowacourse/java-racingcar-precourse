/*
 *  @OutputView.java
 *
 *  @Version: 0.3
 *
 *  @Date: 2019.12.09
 *
 *  @Author: pandahun
 */
package io;

import domain.RacingCars;
import domain.Car;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class OutputView {

    private static final String LOAD = "-";
    private static final String DELIMITER = ", ";

    public static void showNow( RacingCars racingCars ) {
        for(Car car : racingCars.getCars()) {
            String currentPosition = makeDigit(car.getPosition());
            System.out.println(car.getName()+": " +currentPosition);
        }
        System.out.println();
    }

    private static String makeDigit(int position) {
        String digit = "";
        for(int i = 0 ; i < position; i++) {
            digit +=LOAD;
        }
        return digit;
    }

    public static void showWinners(List<Car> winners) {
        String names = String.join(DELIMITER, getWinnersName(winners));
        System.out.println(names+"가 최종 우승하였습니다" );

    }

    private static List<String> getWinnersName(List<Car> winners) {
        return winners.stream()
                .map(Car::getName)
                .collect(toList());
    }
}
