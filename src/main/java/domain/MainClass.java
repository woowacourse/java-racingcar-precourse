/*
 * 	@(#)MainClass.java    ver1.0.0    04/04/2019
 *  우아한 테크코스 2주차 미션 - 자동차 경주 게임
 */
package domain;

import java.util.Scanner;

/**
 * MainClass: 자동차 경주 게임을 담당하는 클래스이다.
 *
 * @author  김선관
 * @version ver1.0.0
 */
public class MainClass {
    static public Scanner scanner = new Scanner(System.in);

    /**
     * names:  사용자로부터 입력받은 자동차의 이름들이 저장되는 배열
     * cars:   객체화한 자동차들이 저장되는 배열
     * moveIn: 사용자로부터 입력받은 이동 횟수가 저장되는 변수
     */
    static String[] names;
    static Car[] cars;

    /**
     * main: 다음의 기능을 순차적으로 실행한다.
     * - 사용자로부터 자동차의 이름을 입력받는다.
     * - 입력받은 이름으로 자동차를 객체화한다.
     * - 사용자로부터 경주 횟수를 입력받는다.
     * - 입력받은 경주 횟수만큼 자동차 경주를 실행한다.
     * - 매 경주가 끝날 때 마다 경주 현황을 출력한다.
     * - 자동차 경주가 끝난 후 우승자를 고른다
     * - 우승자를 출력한다.
     *
     * @param args: 사용하지 않음.
     */
    static public void main(String[] args) {
        int moveIn;
        names = userInName().split(",");    //사용자로부터 입력받은 문자열 원본을 구분자 ','로 분할하여 names 배열에 저장.
        cars = makeCar();
        moveIn = userInMove();
        doRace(moveIn);
        selectWinner();

        scanner.close();
    }

    /**
     * userInName: 사용자로부터 자동차의 이름을 입력받는 메소드
     *
     * @return nameIn: 사용자로부터 입력받은 문자열
     */
    static public String userInName() {
        String nameIn;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        nameIn = scanner.next();

        return nameIn;
    }

    /**
     * makeCar: 입력받은 이름을 이용하여 Car class 를 객체화하는 메소드
     *
     * @return cars: Car 객체들이 저장된 배열
     */
    static public Car[] makeCar() {
        Car[] cars = new Car[names.length];
        for (int i = 0; i < names.length; ++i) {
            cars[i] = new Car(names[i]);
        }

        return cars;
    }

    /**
     * userInMove: 사용자로부터 몇 번의 이동을 할 것인지를 입력받는 메소드
     *
     * @return: 몇 번의 이동을 할 것인지를 나타내는 int형 변수를 반환함
     */
    static public int userInMove() {
        int moveIn;
        System.out.println("시도할 회수는 몇회인가요?");
        moveIn = scanner.nextInt();

        return moveIn;
    }

    /**
     * moveIn 만큼 루프를 돈다. 매 루프마다 각 자동차를 Car class 의 goStop 메서드를 사용한다.
     * 그 후 printRace(메서드 5)를 통해 경기 현황을 출력한다.
     *
     * @param moveIn: 경주 횟수를 저장한 변수
     */
    static public void doRace(int moveIn) {
        while (true) {
            if (moveIn <= 0) {
                break;
            }

            for (int i = 0; i < names.length; ++i) {
                cars[i].goStop();
            }
            printRace();
            moveIn--;
        }
    }

    /**
     * cars 에 담겨있는 객체들의 position 변수에 접근하여 경기 현황을 출력하는 메서드이다.
     * Car class 의 getPos 메서드를 사용한다.
     */
    static public void printRace() {
        for (int i = 0; i < names.length; ++i) {
            System.out.print(names[i] + ":");
            for (int j = 0; j < cars[i].getPos(); ++j) {
                System.out.print('-');
            }
            System.out.print('\n');
        }
        System.out.print("\n\n");
    }

    /**
     * selectWinner: 자동차 경주의 우승자를 찾는 메서드이다.
     */
    /*
     *  우승자를 찾는 알고리즘은 다음과 같다.
     * 1. cars 배열에 있는 객체 중 가장 높은 position 값을 구한다.
     * 2. 최대 position 값과 같은 position 값을 갖고 있는 객체의 이름을 전부 출력한다.
     */
    static public void selectWinner() {
        int maxPos = cars[0].getPos();

        for (int i = 1; i < names.length; ++i) {
            if (cars[i].getPos() > maxPos) {
                maxPos = cars[i].getPos();          //전체 Car 객체 중 가장 높은 최대 position 값을 구한다.
            }
        }
        for (int i = 0; i < names.length; ++i) {
            if (cars[i].getPos() == maxPos) {
                printWinner(i);                     //최대 position 값과 같은 position 값을 갖고 있는 객체의 이름을 전부 출력.
            }
        }
        System.out.println("\b\b가 최종 우승했습니다.");
    }

    /**
     * printWinner(carIndex): cars 배열의 carIndex 번째 객체의 이름을 출력한다.
     *
     * @param carIndex: selectWinner 메서드에서 찾은 우승자 car 객체의 index
     */
    static public void printWinner(int carIndex) {
        System.out.print(cars[carIndex].getName() + ", ");
    }
}
