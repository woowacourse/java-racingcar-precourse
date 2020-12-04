package racingcar;

import java.util.ArrayList;
import java.util.Scanner;

public class RacingCarGame {

    ArrayList<Car> carList = new ArrayList<>();
    private int carCount = 0;
//    private int firstScore = 0;

    public void start(Scanner scanner) {
        carNamesInput(scanner);
        printCarName();
    }
    private void carNamesInput(Scanner scanner){
        try {
            System.out.println(Constants.NAME_INPUT_REQ_MSG);
            String names = scanner.nextLine();
            if(!Validator.isValidName(names)) throw new Exception(Constants.STANDARD_ERROR_MSG);
            setCarList(names);

        } catch (Exception e) {
            System.err.println(e.getMessage() + " " + Constants.NAME_ERROR_MSG);
            carNamesInput(scanner);
        }
    }

    private void setCarList(String names){
        String[] splitNames = names.split(",");
        for(String name : splitNames){
            carList.add(new Car(name));
            carCount++;
        }
    }

    private void printCarName(){
        for(Car car : carList){
            System.out.println(car.getName());
        }
    }
}
