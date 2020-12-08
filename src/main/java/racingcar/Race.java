package racingcar;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static racingcar.InputExceptionController.checkInputCars;
import static racingcar.InputExceptionController.checkParticipation;

public class Race {
    private ArrayList<Car> cars = new ArrayList();
    private ArrayList<String> winners = new ArrayList();
    private int times;
    private int maxPosition;

    // 초기 준비 메서드
    public void startRace(Scanner scanner){
        inputCars(scanner);
        checkParticipationCars(cars);
        inputTimes(scanner);

    }

    // 경주 진행 메서드
    public void runRace(){
        for (int i = 0; i < times; i++){
            System.out.println("Lap #"+(i+1));
            for(Car car : cars){
                car.moveCar();
                car.printCarPosition();
            }
        }
    }

    // 차량 입력 메서드
    public void inputCars(Scanner scanner){
        for (String inputCar : scanner.nextLine().split(",")){
            String participationCar = inputCar.replaceAll(" ","");
            try {
                checkInputCars(cars, participationCar);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.exit(0);
            }
            cars.add(new Car(participationCar));
        }
    }

    // 시도횟수 입력 메서드
    public void inputTimes(Scanner scanner){
        try{
            times = scanner.nextInt();
        } catch (InputMismatchException e){
            System.out.println("[ERROR]숫자형식이 아닙니다.");
            System.exit(0);
        }
    }

    // 참가인원 확인 메서드
    public void checkParticipationCars(ArrayList<Car> cars){
        try{
            checkParticipation(cars);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }

    }

    // 가장 먼 위치 확인 메서드
    public void findMaxPosition(){
        for (Car car : cars){
            if (maxPosition < car.getCarPosition()) { maxPosition = car.getCarPosition(); }
        }
    }

    // 우승자 출력 메서드
    public void printWinnerList(){
        findMaxPosition();
        for (Car car : cars){
            if (car.getCarPosition() == maxPosition){ winners.add(car.getCarName()); }
        }
        System.out.println("최종 우승자 : " + String.join(",",winners));
    }
}
