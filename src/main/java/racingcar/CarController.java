package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.NumberValidator;

import static racingcar.CarView.*;
import static util.CarConstant.*;

public class CarController {

    private final Cars cars;
    public CarController(Cars cars){
        this.cars = cars;
    }

    public void play(){
        saveCars();
        int numberOfTry = insertNumberOfTry();
        movePosition(numberOfTry);
        printFinalWinner(cars.getWinners());
    }

    private void saveCars(){
        printMessage(REQUEST_NAME);
        try {
            cars.saveCars(Console.readLine());
        }catch (IllegalArgumentException e){
            printMessage(e.getMessage());
            saveCars();
        }
    }

    private int insertNumberOfTry() {
        printMessage(REQUEST_NUMBER_TO_TRY);
        String inputNumber = Console.readLine();
        try {
            NumberValidator.isRightTryNumber(inputNumber);
        }catch (IllegalArgumentException e){
            printMessage(e.getMessage());
            return insertNumberOfTry();
        }
        breakLine();
        return Integer.parseInt(inputNumber);
    }

    private void movePosition(int numberOfTry) {
        printMessage(EXECUTION_RESULT);
        while (numberOfTry-- > ZERO){
            cars.updateCarPosition();
            cars.getAllCars()
                    .forEach(car -> printImplResult(car));
            breakLine();
        }
    }

}
