package racingcar;


import domain.Car;
import domain.CarList;
import domain.Turn;
import utils.Validation;
import view.InputView;
import view.OutputView;


public class Game {
    private CarList cars;
    private int turns;
    private Validation validation = new Validation();

    public Game(){
        this.cars = setCarList();
        this.turns = setTurns().getTurns();
    }

    public void start(){
        for(int i = 0; i < turns; i++) {
            for (Car car : cars.getCarList()) {
                car.goOrStop();
                OutputView.printNow(cars.getCarList());
            }
        }
        OutputView.printEnd(cars.decideWinner());
    }

    private CarList setCarList(){
        CarList carList = null;
        try{
            String inputCars = InputView.getCarList();
            validation.carValidate(inputCars);
            carList = new CarList(inputCars.split(","));

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            setCarList();
        }

        return carList;
    }

    private Turn setTurns(){
        Turn turns = null;
        try {
            String inputTimes = InputView.getTimes();
            validation.timesValidate(inputTimes);

            turns = new Turn(Integer.valueOf(inputTimes));

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setTurns();
        }
        return turns;
    }
}
