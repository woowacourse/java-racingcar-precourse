package domain;
/**
 * Created by gram on 2019-12-05.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static String[] carName;
    static Car[] car;
    static int movingNum;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        inputCarName();
        car = new Car[carName.length];
        inputMovingNum();
        createCar();
        playGame();
    }

    private static void inputCarName() {
        String totalInputName;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표 기준으로 구분) : ");
        totalInputName = sc.next();
        carName = totalInputName.split(",");
        if( !checkFormAboutName() ) {
            System.out.println("5글자 내로 입력해주세요.");
            inputCarName();
        }
    }

    private static boolean checkFormAboutName() {
        for(int i = 0; i < carName.length; i++) {
            if(carName[i].length() > 5) {
                return false;
            }
        }
        return true;
    }

    private static void inputMovingNum() {
        System.out.println("시도할 횟수는 몇회인가요?");
        movingNum = sc.nextInt();
    }

    private static void createCar() {
        for(int i = 0; i < carName.length; i++) {
            car[i] = new Car(carName[i]);
        }
    }

    private static void playGame() {
        int[] randomNum = new int[carName.length];
        for(int i = 0; i < movingNum; i++) {
            //차 별로 난수 생성
            makeRandomNumber(randomNum);
            //난수만큼 게임 진행
            advanceAccordingToARandomNum(randomNum);
        }
    }

    private static void makeRandomNumber(int[] randomNum) {
        for(int i = 0; i < carName.length; i++) {
            randomNum[i] =(int)(Math.random() * 10);
        }
    }

    private static void advanceAccordingToARandomNum(int[] randomNum) {
        for(int i = 0; i < carName.length; i++) {
            if(randomNum[i] >= 4){
                car[i].addPosition();
            }
        }
    }
}
