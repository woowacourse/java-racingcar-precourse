package racegame;

import racingcar.Car;

import java.util.ArrayList;
import java.util.List;

import static racegame.Constant.*;

public class OutputView {

    public OutputView() {
    }

    public static void printNormal(String normalMessage) {
        System.out.println(normalMessage);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.print(ERROR_HEADER);
        System.out.println(errorMessage);
    }

    public static void printRoundResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.print(car.getName());
            System.out.print(OUTPUT_VIEW_DIVIDER);
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print(OUTPUT_VIEW_CAR_POSITION_MARK);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printWinners(List<Car> carList) {
        System.out.print(OUTPUT_VIEW_WINNER_HEADER);

        int maxPosition = getMaximumPosition(carList);
        StringBuffer winners = getWinnersStringBuffer(carList, maxPosition);

        System.out.println(winners);
    }

    private static int getMaximumPosition(List<Car> carList){
        List<Integer> list = new ArrayList<>();
        for (Car car : carList) {
            list.add(car.getPosition());
        }
        return list.stream().max(Integer::compare).orElse(0);
    }

    private static StringBuffer getWinnersStringBuffer(List<Car> carList, int maxPosition){
        StringBuffer winners = new StringBuffer();
        for(Car car : carList){
            if(car.getPosition() == maxPosition) {
                winners = printNameDelimiter(winners, winners.length());
                winners.append(car.getName());
            }
        }
        return winners;
    }

    private static StringBuffer printNameDelimiter(StringBuffer winners, int length){
        if(length >0){
            winners.append(OUTPUT_VIEW_WINNER_DELIMITER);
        }
        return winners;
    }
}
