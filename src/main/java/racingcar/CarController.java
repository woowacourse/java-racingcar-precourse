package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

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
        printFinalWinner();
    }

    private int saveCars(){
        System.out.println(REQUEST_NAME);
        try {
            return carService.saveCars(Console.readLine());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return saveCars();
        }

    }

    private int insertNumberOfTry() {
        System.out.println(REQUEST_NUMBER_TO_TRY);
        String inputNumber = Console.readLine();
        try {
            CarValidator.isRightTryNumber(inputNumber);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return insertNumberOfTry();
        }
        breakLine();
        return Integer.parseInt(inputNumber);
    }

    private void movePosition(int numberOfTry) {
        System.out.println(EXECUTION_RESULT);
        while (numberOfTry-- > ZERO){
            carService.updateCarPosition();
            carService.findAllCars()
                    .forEach(car -> printImplResult(car));
            breakLine();
        }
    }

    private void printImplResult(Car car){
        int position = car.getPosition();
        StringBuilder sb = new StringBuilder();
        while(position-- > ZERO){
            sb.append(MARK);
        }
        String positionMark = sb.toString();
        System.out.println(car.getName() + SEPARATOR + positionMark);
    }

    private void printFinalWinner(){
        List<Car> winners = carService.findWinners();
        System.out.print(FINAL_WINNER + SEPARATOR);
        if(winners.size() > 1){
            System.out.println(createWinnersName(winners));
            return ;
        }
        System.out.println(winners.get(ZERO).getName());
    }

    private String createWinnersName(List<Car> winners) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < winners.size(); i++){
            sb.append(winners.get(i).getName());
            if(i != winners.size()-1){
                sb.append(DELIMITER + SPACE);
            }
        }
        return sb.toString();
    }

    private void breakLine() {
        System.out.println();
    }

}
