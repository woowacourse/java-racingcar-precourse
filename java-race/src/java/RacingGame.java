package java;

import java.security.DomainCombiner;

import java.util.ArrayList;
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
}