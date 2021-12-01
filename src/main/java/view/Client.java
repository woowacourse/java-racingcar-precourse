package view;

import utils.Validation;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.Console.readLine;


public class Client {

    private Validation validation = new Validation();
    private List<String> carList;
    private int times;

    public void setCarList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCars = readLine();

        validation.carValidation(inputCars);

        carList = Stream.of(inputCars.split(","))
                .collect(Collectors.toList());

    }

    public void setTimes() {
        System.out.println("시도할 회수는 몇회인가요?");

        String inputTimes = readLine();
        validation.timesValidation(inputTimes);

        times = Integer.parseInt(inputTimes);
    }

    public List<String> getCarList(){
        return this.carList;
    }

    public int getTimes(){
        return this.times;
    }
}
