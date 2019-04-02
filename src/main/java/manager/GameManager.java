package manager;

import domain.Car;

import java.util.ArrayList;
import java.util.Scanner;

public class GameManager {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private Car[] cars;
    private int carNumber;
    private StringBuilder sb = new StringBuilder();
    private Scanner scanner = new Scanner(System.in);
    private int validGameLoop;

    public void start() {
        initRacing(); /* 게임시작 전 올바른 자동차 이름,시도할 횟수 입력받기 위한 함수 */
        racing();
    }

    private void initRacing() {

        boolean nameLengthChecker = false;
        String[] carNames = null;
        boolean gameLoopChecker = false;
        String gameLoop;

        while (!nameLengthChecker) {    /* 자동차 이름길이 검사를 위한 while 문 */
            carNames = enterCarNames();
            nameLengthChecker = checkCarNameLength(carNames);
        }
        makeCarObjects(carNames);   /* 검사를 통과하면 입력한 자동차이름만큼 객체를 생성 */

        while (!gameLoopChecker) {  /* 시도할 횟수의 유효성을 체크하는 while 문 */
            gameLoop = enterLoopCount();
            gameLoopChecker = checkGameLoopFormat(gameLoop);
        }

    }

    private String[] enterCarNames() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = scanner.next();

        return carNames.split(",");

    }

    private String enterLoopCount() {

        System.out.println("시도할 횟수는 몇회인가요?");
        String inputGameLoop = scanner.next();
        System.out.println();

        return inputGameLoop;

    }

    private void makeCarObjects(String[] carNames) {

        carNumber = carNames.length;
        cars = new Car[carNames.length]; //자동차 이름의 개수만큼 배열 생성

        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);  //Car 타입배열에 입력한 자동차이름을 넣음
        }

    }

    private boolean checkGameLoopFormat(String gameLoop) {

        try {
            validGameLoop = Integer.valueOf(gameLoop);
            return true;
        } catch (NumberFormatException e) {
            System.out.println(ErrorCodes.INPUT_FORMAT_ERROR); //시도할 횟수가 숫자 이외의 입력이라면 에러 출력
            return false;
        }

    }

    private boolean checkCarNameLength(String[] carNames) {

        for (String carName : carNames) {
            if (carName.length() > MAX_CAR_NAME_LENGTH) {
                System.out.println(ErrorCodes.INPUT_LENGTH_ERROR); //자동차 이름의 길이가 5를 넘는다면 에러 출력 및 다시입력
                return false;
            }
        }
        return true;

    }

    private void racing() {
        /* 모든 입력을 끝낸뒤 결과 출력을 시작하게하는 메소드 */
        printGameState(validGameLoop);

    }


    private void printGameState(int gameRepeat) { /* 자동차 개수를 입력 횟수만큼 */

        System.out.println("실행결과");

        for (int i = 0; i < gameRepeat; i++) {
            for (int j = 0; j < carNumber; j++) {
                cars[j].oneLoop(); // 입력횟수만큼 차이름과 위치를 출력하기위한 oneLoop() 메소드 호출
            }
            System.out.println();
        }

        findWinner();

    }

    private void findWinner() {

        int winnerPosition = cars[0].getPosition();
        ArrayList<String> winnerList = new ArrayList<>();

        for (int i = 1; i < carNumber; i++) {
            if (winnerPosition < cars[i].getPosition()) {
                winnerPosition = cars[i].getPosition(); //레이싱이 끝난후 position의 최대값
            }
        }

        for (int i = 0; i < carNumber; i++) {
            if (cars[i].getPosition() == winnerPosition) {
                winnerList.add(cars[i].getName()); // position 최대값과 현재위치가 같은 car 이름을 list에 추가
            }
        }

        printWinner(winnerList);

    }

    private void printWinner(ArrayList<String> winnerList) {

        int checkWinnerNum = 0;

        if (winnerList.size() == 1) { //우승자가 한명일경우 실행
            System.out.println(winnerList.get(0) + "가 최종 우승했습니다.");
            return;
        }

        for (int i = 0; i < winnerList.size(); i++) { //우승자가 2명이상일 때 실행
            sb.append(winnerList.get(i));
            checkWinnerNum++;
            if (checkWinnerNum < winnerList.size()) {
                sb.append(", ");
            }
        }
        sb.append("가 최종 우승했습니다.");

        System.out.println(sb.toString()); //최종 결과 출력문

    }

}
