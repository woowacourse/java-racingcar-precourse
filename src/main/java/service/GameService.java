package service;

import domain.Car;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 게임 진행에 있어 도움을 주는 기능들
 *
 * @version 1.0(2019.04.01)
 * @author  김종윤
 */
public class GameService {
    /*
     * 구현 기능
     * 1.자동차들의 이름 입력받고 가공
     * 2.자동차 등록하기
     * 3.시도 횟수만큼 레이스 진행
     * 4.시도 횟수 입력받기
     * 5.우승자 확인
     * 6.우승자 출력
     */

    static Scanner scanner = new Scanner(System.in);

    /**
     * 자동차들의 입력을 받고 ,를 기준으로 이름들을 나누기
     *
     * @return String[] 나누어진 자동차 이름들
     */
    public String[] inputAndProcessNames(){
        NamingService namingService = new NamingService();
        String input = namingService.inputCarName();
        String[] names = namingService.splitNames(input);
        return names;
    }

    public ArrayList<Car> registerCars(String[] names){
        ArrayList<Car> cars = new ArrayList<>();
        int numOfCars = names.length;
        for(int i = 0; i < numOfCars; i++){
            Car car = new Car(names[i]);
            cars.add(car);
        }
        return cars;
    }

    public void runningRace(ArrayList<Car> registeredCars){
        System.out.print("\n");
        System.out.println("========실행 결과========");
        int numOfAttempt = inputAttemptCount();
        for(int i = 1; i <= numOfAttempt; i++){
            System.out.println("------[" + i + "번째 시도]-------");
            for(Car car : registeredCars){
                System.out.print(car.getName() + " : ");
                car.moveCar();
                car.printPosition();
            }
            System.out.println("-------------------------");
        }
    }

    public int inputAttemptCount(){
        System.out.println("시도할 회수는 몇회인가요?");
        int numOfAttempt = scanner.nextInt();
        return numOfAttempt;
    }

    public ArrayList<String> checkWinner(ArrayList<Car> registeredCar){
        ArrayList<String> racingWinners = new ArrayList<>();
        int maxDistance = 0;
        for(Car car : registeredCar){
            int curCarDist = car.getPosition();
            if(curCarDist > maxDistance){
                racingWinners.clear();
                racingWinners.add(car.getName());
                maxDistance = curCarDist;
            }else if(curCarDist == maxDistance){
                racingWinners.add(car.getName());
            }
        }
        return racingWinners;
    }

    public void printWinner(ArrayList<String> racingWinners){
        for(String winner : racingWinners){
            System.out.print(winner);
            if(winner != racingWinners.get(racingWinners.size() - 1)){
                System.out.print(", ");
            }
        }
        System.out.println("(이)가 최종 우승했습니다.");
        System.out.println("축하드립니다!!!");
    }
}
