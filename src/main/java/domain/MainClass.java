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
        names = userInName().split(",");
        cars = makeCar(names);
        moveIn = userInMove();
//        doRace();
//        selectWinner();
//        printWinner();
        scanner.close();
    }

    /**
     * userInName: 사용자로부터 자동차의 이름을 입력받는 메소드
     *
     * @return: String nameIn
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
     * @return
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

//    doRace;
//    printRace;
//    selectWinner;
//    printWinner;
}
