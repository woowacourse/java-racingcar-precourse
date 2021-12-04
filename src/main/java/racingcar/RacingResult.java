package racingcar;

import java.util.Queue;

public class RacingResult {
    public static String from(Queue<Car> carList) {
        StringBuilder stringBuilder = new StringBuilder();
        Car first = carList.poll();
        first.writeName(stringBuilder);

        while(!carList.isEmpty()) {
            stringBuilder.append(", ");
            carList.poll().writeName(stringBuilder);
        }

        return stringBuilder.toString();
    }
}
