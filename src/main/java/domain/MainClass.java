/*
 * 	@(#)MainClass.java    ver1.0.0    04/04/2019
 *  우아한 테크코스 2주차 미션 - 자동차 경주 게임
 */
package domain;

import java.util.Scanner;

/**
 * MainClass: 자동차 경주 게임을 담당하는 클래스이다.
 *
 * @author            김선관
 * @version           ver1.0.0
 */
public class MainClass {
    static public Scanner scanner = new Scanner(System.in);

    /**
     * names: 사용자로부터 입력받은 자동차의 이름들이 저장되는 배열
     */
    static String[] names;

    static public void main (String[] args) {
        names = userInName().split(",");
//        makeCar();
//        userInMove();
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
//    makeCar;
//    userInMove;
//    doRace;
//    printRace;
//    selectWinner;
//    printWinner;
}
