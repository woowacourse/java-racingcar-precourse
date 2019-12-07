package main;

import domain.Race;

/**
 * MainClass는 프로그램을 실행하기 위한 main 함수를 포함하는 클래스이다.
 *
 * @author kafka
 * @version 1.0
 */
public class MainClass {
    /**
     * main 함수는 프로그램 시작 시 호출되는 정작 함수이다.
     * Race 객체를 만들어 경주를 실행한다.
     *
     * @param args : 기본 파라미터
     */
    public static void main(String[] args) {
        Race race = new Race();
        race.raceStart();
    }
}
