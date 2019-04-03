package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

class Console {

    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    private void writeStartMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    String readCars() throws IOException {
        writeStartMessage();
        return bufferedReader.readLine();
    }

    private void writeRoundMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    int readRoundCount() throws IOException {
        writeRoundMessage();
        return Integer.parseInt(bufferedReader.readLine());
    }

    void writeRoundStartMessage() {
        System.out.println();
        System.out.println("실행결과");
    }

    void writeRoundResult(List<Car> carList) {
        carList.forEach(car -> System.out.println(car.getName() + " : " + positionMessage(car.getPosition())));
        System.out.println();
    }

    private String positionMessage(int carPosition) {
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < carPosition; i++) {
            message.append("-");
        }
        return message.toString();
    }

    void writeGameResult(List<String> winners) {
        System.out.println(String.join(" , ", winners) + "가 최종 우승했습니다");
    }
}
