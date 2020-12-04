package racingcar;

import java.util.Scanner;

public class Game {
    //참가한 차량 갯수
    private static int numberOfCarsInGame;
    private static int numberOfTrial;
    //진행 해야할 게임의 횟수
    //차량 정보 Cars 배열로 저장
    private static int frontRunnerPosition;

    public static void play(Scanner scanner) {
        GameInformation.getUserInput(scanner);
        numberOfCarsInGame = GameInformation.getNumberOfCarsInGame();
        numberOfTrial = GameInformation.getNumberOfTrial();
        GameInformation.getCarsArray();

        //차수별 실행
        for(int i=0; i<numberOfTrial; i++) {
            singleTrial();
        }

        winnerAnnouncement();
    }

    private static void singleTrial() {
        //자동차 객체 하나씩 랜덤으로 값 구해서 전진 or 멈춤
        for(int i=0; i<numberOfCarsInGame; i++) {
            GameProgression.progressOrStop(/*Car 객체*/);
            GameProgression.printPosition(/*Car 객체*/);
            frontRunnerPosition = GameProgression.checkFrontRunner(/*Car 객체 , */ frontRunnerPosition);
        }
    }

    private static void winnerAnnouncement() {
        for(int i=0; i<numberOfCarsInGame; i++) {
            //frontRunnerPosition 에 해당하면 출력하기
        }
    }
}
