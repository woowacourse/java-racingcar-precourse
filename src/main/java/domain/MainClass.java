/*
 * 	@(#)MainClass.java    ver1.0.0    04/04/2019
 *  우아한 테크코스 2주차 미션 - 자동차 경주 게임
 */
package domain;

import java.util.Scanner;

/**
 * MainClass: 자동차 경주 게임을 담당하는 클래스이다.
 *
 * @author 김선관
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
    static int moveIn;

    static public void main(String[] args) {
        names = userInName().split(",");    //사용자로부터 입력받은 문자열 원본을 구분자 ','로 분할하여 names 배열에 저장.
        cars = makeCar(names);
        moveIn = userInMove();
        doRace(moveIn);
//        selectWinner();
//        printWinner();
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
     * @param names: 사용자로부터 입력받은 이름들이 저장된 배열
     * @return cars: Car 객체들이 저장된 배열
     */
    static public Car[] makeCar(String[] names) {
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
     * @param moveIn
     */
    static public void doRace(int moveIn) {
        while (true) {
            if (moveIn <= 0) {
                break;
            }
            //TODO
            for (int i = 0; i < names.length; ++i) {
                cars[i].goStop();
            }
            printRace();
            moveIn--;
        }
    }

    /**
     * cars에 담겨있는 객체들의 position 변수에 접근하여 경기 현황을 출력하는 메서드이다.
     * Car class의 getPos메서드를 사용한다.
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

//    selectWinner;
//    printWinner;
}
