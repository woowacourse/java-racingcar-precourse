package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.NumberValidator;

import static racingcar.CarView.*;
import static util.CarConstant.*;

public class CarController {

    private final CarService carService;
    public CarController(CarService carService){
        this.carService = carService;
    }

    public void play(){
        saveCars();
        int numberOfTry = insertNumberOfTry();
        movePosition(numberOfTry);
        printFinalWinner(carService.findWinners());
    }

    private int saveCars(){
        printMessage(REQUEST_NAME);
        try {
            return carService.saveCars(Console.readLine());
        }catch (IllegalArgumentException e){
            printMessage(e.getMessage());
            return saveCars();
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
            carService.updateCarPosition();
            carService.findAllCars()
                    .forEach(car -> printImplResult(car));
            breakLine();
        }
    }

}
