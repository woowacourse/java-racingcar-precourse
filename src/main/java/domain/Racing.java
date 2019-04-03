/*
 * 이 클래스는 자동차 경주 게임을 실행하기 위한 클래스로 게임 진행을 위한 메소드와 인스턴스가 있습니다
 *
 *
 * 클래스 이름    Racing
 *
 * 버전 정보     1.0
 *
 * 날짜    2019/04/01
 *
 * 저작권   권유상
 */

package domain;

import java.util.Scanner;
import java.util.ArrayList;

public class Racing {

    private ArrayList<Car> carList;
    private int numberOfTimes;
    private static final int MAX_NAME_LENGTH = 5;

    private static final String MESSAGE_INPUT_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String MESSAGE_INPUT_NUMBER = "시도할 횟수를 입력해주세요: ";
    private static final String MESSAGE_ERROR_NAME = "5자 이하의 이름으로 입력해주세요";
    private static final String MESSAGE_ERROR_NEGATIVE_NUMBER = "0보다 큰 숫자로 입력해주세요";
    private static final String MESSAGE_ERROR_NOT_NUMBER = "숫자를 입력해주세요";
    private static final String MESSAGE_RESULT = "가 최종 우승했습니다.";

    public Racing() {
        this.carList = new ArrayList<Car>();
        this.numberOfTimes = 0;
    }

    public void runGame() {
        inputCarName();
        inputMovingNumber();
        System.out.println("실행결과");
        startRacing();
        printResult();
    }

    private void inputCarName() {
        Scanner scan = new Scanner(System.in);
        String carName;
        do {
            System.out.println(MESSAGE_INPUT_NAME);
            carName = scan.nextLine();
        }
        while (!isCorrectCarName(carName));
        createCar(carName);
    }

    private void createCar(String str) {
        String[] names = str.split(",");
        for (String name : names) {
            Car car = new Car(name);
            this.carList.add(car);
        }
    }

    private void inputMovingNumber() {
        Scanner scan = new Scanner(System.in);
        String number;
        do {
            System.out.print(MESSAGE_INPUT_NUMBER);
            number = scan.nextLine();
        }
        while (!isCorrectMovingNumber(number));
        this.numberOfTimes = Integer.parseInt(number);
    }

    private boolean isCorrectMovingNumber(String num) {
        try {
            int integerNum = Integer.parseInt(num);
            if (integerNum <= 0) {
                System.out.println(MESSAGE_ERROR_NEGATIVE_NUMBER);
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println(MESSAGE_ERROR_NOT_NUMBER);
            return false;
        }
        return true;
    }

    private boolean isCorrectCarName(String str) {
        int charCount = 0;      //글자수를 세기 위한 변수
        for (int i = 0; i < str.length(); i++) {
            charCount++;
            if (str.charAt(i) == ',') {
                charCount = 0;
            }
            if (str.charAt(i) == ' ' || charCount > MAX_NAME_LENGTH) {
                System.out.println(MESSAGE_ERROR_NAME);
                return false;
            }
        }
        return true;
    }

    private void startRacing() {
        for (int i = 0; i < numberOfTimes; i++) {
            for (int j = 0; j < carList.size(); j++) {
                carList.get(j).updatePosition();
                carList.get(j).printPosition();
            }
            System.out.println();
        }
    }

    private void printResult() {
        int maxPosition = 0;
        String winner = "";
        // carList에서 가장 큰 position을 찾는다
        for (int i = 0; i < carList.size(); i++) {
            maxPosition = Math.max(maxPosition, carList.get(i).getPosition());
        }
        // carList에서 가장 큰 position과 같은 position을 가진 Car 객체의 name을 winner에 추가한다
        for (int i = 0; i < carList.size(); i++) {
            if (maxPosition == carList.get(i).getPosition()) {
                winner += carList.get(i).getName() + ",";
            }

        }
        winner = winner.substring(0, winner.length() - 1);      //마지막 ","문자를 제거하기 위함
        System.out.println(winner + MESSAGE_RESULT);
    }
}
