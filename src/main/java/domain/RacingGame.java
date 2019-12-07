/*
 * @(#)RacingGame.java     0.5 2019.12.07
 *
 * Copyright (c) 2019 lxxjn0.
 */
package domain;

import java.util.*;
import java.util.regex.Pattern;

/**
 * 사용자로부터 자동차의 이름을 입력받고 게임을 진행 후 우승자를 출력하는 전반적인 진행을 담당하는 클래스.
 *
 * @author JUNYOUNG LEE (lxxjn0)
 * @version 0.5 2019.12.07
 */
public class RacingGame {
    /**
     * 문자열에서 쉼표(,)를 확인하기 위한 문자 상수.
     */
    private static final char COMMA_CHAR = ',';

    /**
     * 문자열을 쉼표(,)를 기준으로 자를 때 사용하기 위한 문자열 상수.
     */
    private static final String COMMA_STRING = ",";

    /**
     * 이동 횟수가 1 이상인 정수인지 확인하기 위한 정수 상수.
     */
    private static final int MIN_MOVEMENT_NUMBER = 1;

    /**
     * 문자열에서 쉼표(,)의 앞, 뒤로 존재하는 공백을 제거할 때 사용할 정규식 문자열 상수.
     */
    private static final String REMOVE_SPACE_AROUND_COMMA =
            "(\\s,\\s)|(\\s,)|(,\\s)";

    /**
     * 자동차의 이름이 영문자 또는 숫자로만 이루어져 있는지 확인하기 위한 정규식 문자열 상수.
     */
    private static final String VALID_CAR_NAME_FORMAT = "^[a-zA-Z0-9]*$";

    /**
     * 사용자의 입력을 저장하기 위한 문자열 변수.
     */
    private String userInput;

    /**
     * 사용자로부터 이동 횟수를 저장하기 위한 정수 변수.
     */
    private int MovementNumber;

    /**
     * 입력받은 자동차의 이름을 저장할 List 변수.
     */
    private List<String> carNames;

    /**
     * 생상한 자동차 객체들을 저장할 Car 클래스형 List 변수.
     */
    private List<Car> cars;

    /**
     * 사용자로부터 자동차의 이름을 받아오는 것부터 우승 결과까지 출력하는 전체 진행을 담당하는 메소드.
     */
    public void run() {
        receiveCarNames();
        generateCarInstances();
        receiveNumberOfMovement();
        for (int i = 0; i < MovementNumber; i++) {
            playRacingGame();
            printMoveResult();
            System.out.println(" ");
        }
    }

    /**
     * 모든 자동차들에게 이동을 진행시키는 메소드.
     */
    private void playRacingGame() {
        for (Car car : cars) {
            car.moveCarToForward();
        }
    }

    /**
     * 자동차들의 진행이 끝나고 실행 결과를 출력하는 메소드.
     */
    private void printMoveResult() {
        System.out.println("실행 결과");
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            printMoveBar(car.getPosition());
        }
    }

    /**
     * 자동차의 position만큼 -(하이픈)을 출력하는 메소드.
     *
     * @param position 자동차의 현재 위치.
     */
    private void printMoveBar(int position) {
        StringBuilder moveBar = new StringBuilder();

        for(int i = 0; i < position; i++) {
            moveBar.append("-");
        }
        System.out.println(moveBar);
    }

    /**
     * 자동차의 이름을 입력받아 유효성을 검사 후 처리하여 carNames 문자열 리스트에 저장하는 메소드.
     */
    private void receiveCarNames() {
        Scanner sc = new Scanner(System.in);

        do {
            carNames = new ArrayList<>();

            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            userInput = sc.nextLine();
            removeSpaceAroundComma();
        } while (!isValidInput());
    }

    /**
     * 유효성이 검증된 자동차의 이름들을 가지고 Car 클래스 객체를 생성하는 메소드.
     */
    private void generateCarInstances() {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    /**
     * 사용자로부터 이동 횟수를 입력받는 메소드.
     */
    private void receiveNumberOfMovement() {
        Scanner sc;

        while (true) {
            try {
                sc = new Scanner(System.in);

                System.out.println("시도할 회수는 몇 회인가요?");
                MovementNumber = sc.nextInt();
                isValidNumber();
                break;
            } catch (InputMismatchException e) {
                sc = new Scanner(System.in);
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }

    /**
     * 입력이 정수로 확인된 이후, 해당 정수가 1 이상인지 확인하는 메소드.
     *
     * @throws InputMismatchException 1 이상의 정수가 아니라면 예외 발생.
     */
    private void isValidNumber() throws InputMismatchException {
        if (!(MovementNumber >= MIN_MOVEMENT_NUMBER)) {
            throw new InputMismatchException();
        }
    }

    /**
     * 사용자로부터 입력받은 자동차의 이름이 유효한지 여부를 확인하는 메소드.
     *
     * @return 사용자로부터 입력받은 자동차의 이름이 유효하면 true 반환.
     */
    private boolean isValidInput() {
        if (!isDividedComma()) {
            System.out.println("경주할 자동차 이름을 쉼표(,)를 기준으로 구분하여 입력하세요.");
            return false;
        }
        if (!isValidLength()) {
            System.out.println("경주할 자동차 이름은 5자 이하만 가능합니다. 다시 입력해주세요.");
            return false;
        }
        if (!isValidCarName()) {
            System.out.println("경주할 자동차 이름은 공백을 제외한 영문자와 숫자로만 작성 가능합니다." +
                    " 다시 입력해주세요.");
            return false;
        }
        return true;
    }

    /**
     * 자동차의 이름이 쉼표(,)로 정확히 구분되어져 있는지를 확인하는 메소드.
     *
     * @return 문자열의 맨 앞이나 맨 뒤에 쉼표(,)가 존재하지 않는다면 true 반환.
     */
    private boolean isDividedComma() {
        return ((userInput.charAt(0) != COMMA_CHAR) &&
                (userInput.charAt(userInput.length() - 1) != COMMA_CHAR));
    }

    /**
     * 자동차의 이름을 쉼표(,)를 기준으로 잘라서 List로 반환하는 메소드.
     *
     * @return 자동차 이름이 저장된 List 반환.
     */
    private List<String> splitCarNames() {
        return Arrays.asList(userInput.split(COMMA_STRING));
    }

    /**
     * 모든 자동차의 이름이 1자 이상 5자 이하인지 확인하는 메소드.
     *
     * @return 모든 자동차의 이름의 길이가 유효하면 true 반환.
     */
    private boolean isValidLength() {
        carNames = splitCarNames();

        for (String car : carNames) {
            if ((car.length() < 1) || (car.length() > 5)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 모든 자동차의 이름이 유효한 지(공백이 존재하지 않는 숫자 혹은 영문자로 구성) 확인하는 메소드.
     *
     * @return 모든 자동차의 이름이 유효하다면 true 반환.
     */
    private boolean isValidCarName() {
        for (String car : carNames) {
            if (!Pattern.matches(VALID_CAR_NAME_FORMAT, car)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 사용자의 입력에서 쉼표(,)의 앞, 뒤로 존재하는 불필요한 공백을 제거하는 메소드.
     */
    private void removeSpaceAroundComma() {
        userInput = userInput.replaceAll(REMOVE_SPACE_AROUND_COMMA, ",");
    }
}
