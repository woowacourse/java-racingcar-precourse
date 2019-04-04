package java;

import domain.Car;

import java.security.DomainCombiner;

import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RacingGame {

    private Scanner sc = new Scanner(System.in);
    private ArrayList<Character> carList = new ArrayList<>();
    private int playNum;

    public void inputCarName() throws Exception {
        final String delimiter = ",";
        public void inputCarNameVoid() throws Exception {
        }
    }

    public void inputNumOfPlay() throws InputMismatchException {
        playNum = sc.nextInt();
        public void play() {
            for (int i = 0; i < carList.size(); i++) {
                carList.get(i).goOrStop();
            }
        }
        
        public Void displayCarPosition() {
            for (int i = 0; i < carList.size(); i++) {
                Car car = carList.get(i);
                System.out.print(car.getName() + ":");
                for (int j = 0; j < car.getPosition(); j++) {
                    System.out.print("-");
                }
                System.out.println();
            }
        }
    }
    
    public List<Car> getResult() {
        List<Car> result = new ArrayList<>();

        result.add(carList.get(0));
        for (int i = 1; i < carList.size(); i++) {

            if (result.get(0).getPosition() < carList.get(i).getPosition()) {
                result = new ArrayList<>();
                result.add(carList.get(i));
                continue;
            }
            if (result.get(0).getPosition() == carList.get(i).getPosition()) {
                result.add(carList.get(i));
            }
        }
        return  result;
    }
}