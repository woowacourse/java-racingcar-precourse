package domain;

import java.util.Random;
import java.util.Scanner;

public class DuringRace {

    private static final int RAMDOM_NUMBER_MAX = 10;                        // 난수 범위
    private static final int SET = 1;                                       // 저장 위치
    private static final int ALLOW_GO = 3;                                  // 전진 가능한 최소 난수

    /* 시도 횟수를 입력받는 메소드 */
    public int getRacingCarMove() {

        System.out.println("이동할 횟수를 입력해 주세요");

        Scanner getCarMove = new Scanner(System.in);
        int carMoveNumber = getCarMove.nextInt();

        return carMoveNumber;
    }

    /* 난수 생성 메소드 */
    public int createRandomNumber() {

        Random getRandomNumber = new Random();
        int randomNumber = getRandomNumber.nextInt(RAMDOM_NUMBER_MAX);     // 0~9까지 난수 생성

        return randomNumber;
    }

    /* 난수 값에 따라서 자동차의 경주상태 반환하는 메소드 */
    public boolean checkCarState(int randomNumber) {

        boolean carState = false;

        if (randomNumber > ALLOW_GO) {

            /*난수의 값이 4이상 일 경우 */
            carState = true;                                                // 전진 가능
        }
        return carState;
    }

    /* 자동차 경주 과정을 저장하는 메소드 */
    public void saveDuringRacing(Car[] cars){

        int[] goValue;
        for(int i=0; i<cars.length;i++){

            if(checkCarState(createRandomNumber())){

                /* 자동차가 전진할때 */
                cars[i].carResult.add("-");                                 // 자동차 전진 횟수 문자열 저장
                cars[i].increasePosition();                          // 자동차 전진
            }
        }
    }

    /* 자동차 경주 과정을 출력하는 메소드  */
    public void showDuringRace(Car[] cars){

        for(int i=0;i<cars.length;i++){

            /* Car배열의 크기 만큼 반복 */
            System.out.print(cars[i].getName(cars[i]) + " : ");

            for(int j=0;j<cars[i].carResult.size();j++){

                /* Car배열 각각에 저장된 ArrayList 크기 만큼 반복 */
                System.out.print(cars[i].carResult.get(j));                 // 저장된 ArrayList 출력
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }

    /* 시도 횟수만큼 진행하는 메소드 */
    public void runRacingGame(Car[] cars){

        System.out.println("실행 결과");

        int moveNumber = getRacingCarMove();

        for(int i = moveNumber; i>0; i--){

            /* 입력받은 값만큼 반복*/
            saveDuringRacing(cars);                                         // 레이싱 과정 저장
            showDuringRace(cars);                                           // 레이싱 과정 출력
        }
        showWinner(cars);                                                   // 우승 자동차 출력
    }

    /* 우승 자동차 출력*/
    public void showWinner(Car[] cars){

        int mostGoValue = cars[0].getPosition();                     // 가장 많이 전진한 값을 저장하기 위한 변수

        for(int i=1;i<cars.length;i++){

            /* cars 배열의 크기 만큼 반복 */
            if(cars[i].getPosition() > mostGoValue){

                /* i번째 전진 횟수를 이전과 비교하여 클경우  */
                mostGoValue = cars[i].getPosition();                 // 최대 전진횟수 값 변경
            }
        }

        for(int i=0;i<cars.length;i++){

            /* cars 배열의 크기 만큼 반복 */
            if(cars[i].getPosition() == mostGoValue){

                /* 최대 전진 횟수 하고 같을 경우 */
                cars[SET].firstCarName.add(cars[i].getName(cars[i]));       // SET 위치의 ArrayList에 저장
            }
        }

        System.out.println(String.join(",",cars[SET].firstCarName) + "가 최종 우승 했습니다");
    }
}
