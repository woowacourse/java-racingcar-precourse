package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static constants.ConsoleConstants.*;

class Console {

    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    private void writeStartMessage() {
        System.out.println(START_MESSAGE);
    }

    String readCars() throws IOException {
        writeStartMessage();
        return bufferedReader.readLine();
    }

    private void writeRoundMessage() {
        System.out.println(ASK_COUNT_ROUND);
    }

    int readRoundCount() throws IOException {
        writeRoundMessage();
        return Integer.parseInt(bufferedReader.readLine());
    }

    void writeRoundStartMessage() {
        System.out.println();
        System.out.println(ROUND_START_MESSAGE);
    }

    void writeRoundResult(List<Car> carList) {
        carList.forEach(car -> System.out.println(car.getName() + " : " + positionMessage(car.getPosition())));
        System.out.println();
    }

    private String positionMessage(int carPosition) {
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < carPosition; i++) {
            message.append(POSITION_MESSAGE);
        }
        return message.toString();
    }

    void writeGameResult(List<String> winners) {
        System.out.println(String.join(DELIMITER, winners) + WINNER_MESSAGE);
    }
}
