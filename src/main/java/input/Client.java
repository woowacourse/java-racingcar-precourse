package input;


import domain.CarList;
import domain.Turn;
import utils.Validation;

import static camp.nextstep.edu.missionutils.Console.readLine;


public class Client {
    private static Validation validation = new Validation();

    public static CarList getCarList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCars = readLine();

        validation.carValidate(inputCars);

        return new CarList(inputCars.split(","));

    }

    public static Turn getTimes() {
        System.out.println("시도할 회수는 몇회인가요?");

        String inputTimes = readLine();
        validation.timesValidate(inputTimes);

        return new Turn(Integer.valueOf(inputTimes));
    }

}
