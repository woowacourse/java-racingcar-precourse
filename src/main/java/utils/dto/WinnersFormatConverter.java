package utils.dto;

import domain.Winners;

import java.util.StringJoiner;

public class WinnersFormatConverter {
    public static StringJoiner convertWinnersFormat(Winners winners) {
        StringJoiner sj = new StringJoiner(", ");
        winners.getWinners()
                .forEach(car -> sj.add(car.getCarOriginName()));
        return sj;
    }

}
