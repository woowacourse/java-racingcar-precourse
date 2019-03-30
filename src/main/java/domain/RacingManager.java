/**
 * 클래스 설명
 *
 * @version
 * @author
 */

package domain;

import java.util.ArrayList;
import java.util.Random;

/**
 * 클래스이름.class        버젼 날짜
 *
 * <Copyright 2019. LeeNamJun. All rights reserved.>
 */

public class RacingManager {

    private static Random random = new Random();
    private static Car[] cars;
    private static int carNum;
    /**
     * 0~9 사이의 랜덤한 정수를 리턴해주는 메소드
     * @return 0~9 사의 랜덤한 정수
     */
    private static int getRndNum() {
        return random.nextInt(10);
    }

    /**
     * 사용자에게 자동차들의 이름을 입력하라는 메시지를 출력하는 메소드
     */
    private static void nameEnterMsg() {
        System.out.print("경주할 자동차 이름을 입력하세요.");
        System.out.println("(이름은 쉼표(,) 기준으로 구분)");
    }

    /**
     * 사용자에게 시도할 회수를 입력하라는 멧기지를 출력하는 메소드
     */
    private static void timesEnterMsg() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    /**
     * 사용자가 입력한 이름들의 갯수만큼 자동차를 생성하는 기능
     * @param names 사용자가 입력한 자동차의 이름들
     */
    private static void setCars(String names) {
        String[] namesArr = names.split(",");
        carNum = namesArr.length;

        for(int i = 0; i < carNum; i++) {
            cars[i] = new Car(namesArr[i]);
        }
    }

    /**
     * 실행 결과를 출력해주는 메소드
     */
    private static void printResult() {
        for(int i = 0; i < carNum; i++) {
            System.out.print(cars[i].getName() + " : ");
            for(int j = 0; j < cars[i].getPosition(); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    /**
     * 가장 멀리간 자동차의 위치를 계산하는 메소드
     * @return 가장 멀리간 자동차의 위치 값
     */
    private static int getMax() {
        int max = cars[0].getPosition();

        for(int i = 1; i < carNum; i++) {
            if(max < cars[i].getPosition()) {
                max = cars[i].getPosition();
            }
        }

        return max;
    }

    /**
     * 우승한 자동차들의 이름을 계산하는 메소드
     * @param max 계산된 가장 멀리간 자동차의 위치 값
     * @return 우승한 자동차들의 이름들
     */
    private static ArrayList<String> getWinners(int max) {
        ArrayList<String > winners = new ArrayList<String>();

        for(int i = 0; i < carNum; i++) {
            if(max == cars[i].getPosition()) {
                winners.add(cars[i].getName());
            }
        }

        return  winners;
    }

    /**
     * 우승한 자동차들의 이름을 출력하는 메소드
     * @param winners 우승한 자동차들의 이름
     */
    private static void printWinners(ArrayList<String > winners) {
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
