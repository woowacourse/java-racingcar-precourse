package utils.dto;

import domain.Car;
import domain.RacingCars;

import java.util.stream.Collectors;

public class RacingCarsFormatConverter {
    private static final String MINUS = "-";

    public static String convertRacingCarsFormat(RacingCars racingCars) {
        return racingCars.getRacingCars()
                .stream()
                .map(RacingCarsFormatConverter::joinRacingCarsFormat)
                .collect(Collectors.joining("\n"));
    }

    private static String joinRacingCarsFormat(Car car) {
        return car.getCarOriginName() + " : " + printMinus(car.getPosition());
    }

    private static String printMinus(Integer position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append(MINUS);
        }
        return sb.toString();
    }
}
