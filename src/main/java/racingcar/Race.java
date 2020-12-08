package racingcar;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static racingcar.InputExceptionController.checkInputCars;

public class Race {
    private ArrayList<Car> cars = new ArrayList();
    private ArrayList<String> winners = new ArrayList();

    private int times;
    private int maxPosition;

    public void startRace(Scanner scanner){
        inputCars(scanner);
        inputTimes(scanner);
    }

    public void runRace(){
        for (int i = 0; i < times; i++){
            System.out.println("Lap #"+(i+1));
            for(Car car : cars){
                car.moveCar();
                car.printCarPosition();
            }
        }
    }

    // 예외 처리 필요
    public void inputCars(Scanner scanner){
        for (String participationCar : scanner.nextLine().split(",")){
            try {
                checkInputCars(cars, participationCar);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.exit(0);
            }
            cars.add(new Car(participationCar));
        }
    }

    // 예외 처리 필요
    public void inputTimes(Scanner scanner){
        try{
            times = scanner.nextInt();
        } catch (InputMismatchException e){
            System.out.println("[ERROR]숫자형식이 아닙니다.");
            System.exit(0);
        }
    }


    public void findMaxPosition(){
        for (Car car : cars){
            if (maxPosition < car.getCarPosition()) { maxPosition = car.getCarPosition(); }
        }
    }

    public void printWinnerList(){
        findMaxPosition();
        for (Car car : cars){
            if (car.getCarPosition() == maxPosition){ winners.add(car.getCarName()); }
        }
        System.out.println("최종 우승자 : " + String.join(",",winners));
    }
}
