/*
 *@(#)InputUtility.java           1.1 2019/04/04
 *Copyright (c) 2019 Hyogeon Kim.
 *Racing Car Game, Java, Mungyeong, KOREA
 */

package domain;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 자동차 경주 게임의 전반적인 입력에 관련 된 클래스
 *
 * @author 김효건
 * @version 1.1 2019년 04월 04일
 */

public class InputUtility {
        /*
         * 자동차 배열과 시도횟수를 멤버 변수로 가지고 있고
         * 이를 입력 받고, 예외처리하고, 반환하는 역할을 하는 클래스
         *  */

        /*차 이름 최대 길이*/
        private static final int MAXCARNAMENUMBER = 5;

        private Car[] cars;
        private int trialNumber;

        InputUtility() {
        }

        /*차 배열을 반환*/
        public Car[] getCars() {
                return cars;
        }

        /*시도 횟수를 반환*/
        public int getTrialNumber() {
                return trialNumber;
        }


        /*자동차 이름들을 입력받는 메서드*/
        public boolean inputCarNames() {
                Scanner scan = new Scanner(System.in);
                String inputCarNames = scan.nextLine();

                String[] splitedCarNames = inputCarNames.split(",");
                if (!checkInputCarNames(splitedCarNames))
                        return false;

                makeCars(splitedCarNames);
                return true;
        }

        /*시도 횟수 입력하는 메서드*/
        public boolean inputTrialNumber() {
                Scanner scan = new Scanner(System.in);
                try {
                        trialNumber = scan.nextInt();
                        if (trialNumber < 1)
                                throw new InputTrialNumberNotNaturalNumber();
                } catch (InputMismatchException e) {
                        System.err.println("입력 형식 오류");
                        return false;
                } catch (InputTrialNumberNotNaturalNumber e) {
                        System.err.println("0이하 입력 오류");
                        return false;
                }
                return true;
        }

        /*각각의 자동차 이름에 대한 예외 검사하는 메서드*/
        private boolean checkInputCarNames(String[] carNames) {
                for (int i = 0; i < carNames.length; i++) {
                        if (!checkInputOneCarNames(carNames[i]))
                                return false;
                }
                return true;
        }

        /*하나의 자동차 이름이 올바른지 검사하는 메서드*/
        private boolean checkInputOneCarNames(String carName) {
                if (!checkCarNameLength(carName))
                        return false;
                if (!checkCarNameFormat(carName))
                        return false;
                return true;
        }

        /*자동차 이름 길이에 대한 검사를 하는 메서드*/
        private boolean checkCarNameLength(String carName) {
                if (carName.length() > MAXCARNAMENUMBER) {
                        System.err.println("차 이름 길이 초과 오류");
                        return false;
                }
                return true;
        }

        /*자동차 이름 형식에 대한 검사를 하는 메서드*/
        private boolean checkCarNameFormat(String carName) {
                for (int i = 0; i < carName.length(); i++) {
                        if (!(carName.charAt(i) >= 'a' && carName.charAt(i) <= 'z')
                                && !(carName.charAt(i) >= 'A' && carName.charAt(i) <= 'Z')) {
                                System.err.println("차 이름 입력 형식 오류 (알파벳만 입력)");
                                return false;
                        }
                }
                return true;
        }

        /*자동차 배열을 생성하는 메서드*/
        private void makeCars(String[] splitedCarNames) {
                cars = new Car[splitedCarNames.length];
                for (int i = 0; i < splitedCarNames.length; i++) {
                        cars[i] = new Car(splitedCarNames[i]);
                }
        }

        /*입력한 시도횟수가 음수인 예외*/
        private class InputTrialNumberNotNaturalNumber extends RuntimeException {
        }
}
