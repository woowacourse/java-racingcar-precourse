package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Console {

    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    private void writeStartMessage(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public String readCars() throws IOException {
        writeStartMessage();
        return bufferedReader.readLine();
    }

    private void writeRoundMessage(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public int readRoundCount() throws IOException{
        writeRoundMessage();
        return Integer.parseInt(bufferedReader.readLine());
    }

    public void writeRoundResult(List<Car> carList){
        System.out.println();
        carList.stream().forEachOrdered(car -> System.out.println(car.getName() + " : "+positionMessage(car.getPosition())));
    }

    private String positionMessage(int carPosition){
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < carPosition; i++) {
            message.append("-");
        }
        return message.toString();
    }

    public void writeGameResult(List<Car> carList){
        StringBuilder result = new StringBuilder();
        for (Car car : carList){
            result.append(car.getName()).append(",");
        }
        System.out.println(result + "가 최종 우승했습니다");
    }
}
