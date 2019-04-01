package playRacing;

import domain.Car;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Car[] cars;
    static final String WINNER_MESSAGE="가 최종 우승했습니다.";

    public static void main(String[] args) {
       

    }

    public static boolean isNameValid(String[] names) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].length() > 5) {
                return false;
            }
        }
        return true;
    }

    /**
     * 모든 자동차의 액션(멈춤/전진)을 실행시키는 함수
     */
    public static void startAction() {
        for (int i = 0; i < cars.length; i++) {
            cars[i].goOrStop();
        }
    }

    public static void printAllPostion() {
        StringBuilder allPosition = new StringBuilder();
        for (int i = 0; i < cars.length; i++) {
            allPosition.append(cars[i].printPosition() + "\n");
        }
        System.out.println(allPosition.toString());
    }
    public static String judgeWinner(){
        Arrays.sort(cars);
        StringBuilder winner = new StringBuilder(cars[0].getName());
        int maxPosition=cars[0].getPosition();
        for(int i=1; i<cars.length; i++){
            if(cars[i].getPosition()==maxPosition){
                winner.append(","+cars[i].getName());
            }
        }
        winner.append(WINNER_MESSAGE);
        return winner.toString();
    }

}
