package racingcar;

import java.util.ArrayList;
import java.util.Scanner;

public class Race {
    private ArrayList<Car> cars = new ArrayList();
    private ArrayList<String> winners = new ArrayList();

    private int times;

    public void startRace(Scanner scanner){
        inputParticipationCars(scanner);
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
    public void inputParticipationCars(Scanner scanner){
        for (String participationCar : scanner.nextLine().split(",")){
            cars.add(new Car(participationCar));
        }
    }

    // 예외 처리 필요
    public void inputTimes(Scanner scanner){
        times = scanner.nextInt();
    }


    public int findMaxPosition(){
        int maxPosition = -1;
        int tempPosition;
        for (Car car : cars){
            tempPosition = car.getCarPosition();
            if (maxPosition < tempPosition) { maxPosition = tempPosition; }
        }
        return maxPosition;
    }

    public void printWinnerList(){
        int maxPosition = findMaxPosition();
        for (Car car : cars){
            if (car.getCarPosition() == maxPosition){ winners.add(car.getCarName()); }
        }
        System.out.println("최종 우승자 : " + String.join(",",winners));
    }



}
