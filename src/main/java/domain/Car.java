package domain;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Car 클래스는 자동차 게임에 관련된 모든 상태를 나타내는 클래스 입니다.
 *
 * @version 2019년 3월 30일
 * @author 이중혁
 */

public class Car {
    private final String name;
    private int position = 0;
    private ArrayList<String> carResult = new ArrayList<String>();           // 진행도를 입력받는 ArrayList
    private ArrayList<String> firstCarName = new ArrayList<String>();   // 1등 자동차 이름 저장 ArrayList
    private static final int RAMDOM_NUMBER_MAX = 10;                        // 난수 범위
    private static final int SET = 1;                                       // 저장 위치
    private static final int ALLOW_NAME_LENGTH = 5;                         // 이름 최대 허용범위
    private static final int ALLOW_GO = 3;                                  // 전진 가능한 최소 난수

    public Car(String name) {
        this.name = name;
    }

    public static String getCarName() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        Scanner saveCarName = new Scanner(System.in);
        String carName = saveCarName.nextLine();

        while(!separateCarNameState(carName)){

            /* 입력받은 이름이 요구 조건(차이름은 5자이하)에 만족하지 않을경우 */
            carName = saveCarName.nextLine();
        }

        return carName;
    }

    /*(,) 를 기준으로 단어를 나눴을때 5자 이내 조건을 만족하는지 확인 하는 메소드*/
    public static boolean separateCarNameState(String carName) {

        String[] carNameArray = carName.split(",");         //매개변수를 (,)기준으로 구분후에 배열저장
        boolean carNameState = true;

        for (int i = 0; i < carNameArray.length; i++) {

            /*분리된 자동차 이름 배열 모두 확인 하기 위한 반복문*/
            if (carNameArray[i].length() > ALLOW_NAME_LENGTH) {

                /*자동차 이름이 5자 초과일경우 */
                System.out.println("자동차 이름은 5자 이하 까지만 허용합니다");
                carNameState = false;                               // 자동차 이름 생성 불가
                break;
            }
        }
        return carNameState;
    }

    /*(,)를 기준으로 자동차 이름을 구분 하는 메소드*/
    public static String[] divideCarName(String carName) {

        String[] carNameArray = carName.split(",");             // (,)를 기준으로 분리 하여 배열저장

        return carNameArray;
    }

    /* 자동차 이름배열을 Car배열 각각에 인스턴스 생성과 동시에 초기화 하는 메소드 */
    public static Car[] inputCarName(String[] carNameArray){

        Car[] cars = new Car[carNameArray.length];

        for(int i=0;i<carNameArray.length;i++){

            /* 분리된 이름배열을 Car배열 각각의 name에 인스턴스 생성과 동시에 name 변수 초기화 하는 반복문*/
            cars[i] = new Car(carNameArray[i]);
        }

        return cars;
    }

    /* 시도 횟수를 입력받는 메소드 */
    public static int getRacingCarMove() {

        System.out.println("이동할 횟수를 입력해 주세요");

        Scanner getCarMove = new Scanner(System.in);
        int carMoveNumber = getCarMove.nextInt();

        return carMoveNumber;
    }

    /* 난수 생성 메소드 */
    public static int createRandomNumber() {

        Random getRandomNumber = new Random();
        int randomNumber = getRandomNumber.nextInt(RAMDOM_NUMBER_MAX);     //0~9까지 난수 생성

        return randomNumber;
    }

    /* 난수 값에 따라서 자동차의 상태 반환하는 메소드 */
    public static boolean checkCarState(int randomNumber) {

        boolean carState = false;

        if (randomNumber > ALLOW_GO) {

            /*난수의 값이 4이상 일 경우 */
            carState = true;                                                // 전진 가능
        }
        return carState;
    }

    /* 자동차 경주 과정을 출력하는 메소드  */
    public static void showDuringRace(Car[] cars){

        for(int i=0;i<cars.length;i++){

            /* Car배열의 크기 만큼 반복 */
            System.out.print(cars[i].name + " : ");

            for(int j=0;j<cars[i].carResult.size();j++){

                /* Car배열 각각에 저장된 ArrayList 크기 만큼 반복 */
                System.out.print(cars[i].carResult.get(j));         // 저장된 ArrayList 출력
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }

    /* 자동차를 전진시키는 메소드  */
    public static void increasePosition(Car car){

        car.position++;
    }

    /* 자동차 경주 과정을 저장하는 메소드 */
    public static void saveDuringRacing(Car[] cars){

        for(int i=0; i<cars.length;i++){

            if(checkCarState(createRandomNumber())){

                /* 자동차가 전진할때 */
                cars[i].carResult.add("-");                         // 자동차 전진 횟수 문자열 저장
                increasePosition(cars[i]);                              // 자동차 전진
           }
        }
    }

    /* 시도 횟수만큼 진행하는 메소드 */
    public static void runRacingGame(Car[] cars){

        System.out.println("실행 결과");

        int moveNumber = getRacingCarMove();

        for(int i = moveNumber; i>0; i--){

            /* 입력받은 값만큼 반복*/
            saveDuringRacing(cars);                                     // 레이싱 과정 저장
            showDuringRace(cars);                                       // 레이싱 과정 출력
        }
    }

    /* 공동 우승 차량 출력*/
    public static void showWinner(Car[] cars){

        int mostGoValue = cars[0].position;

        for(int i=1;i<cars.length;i++){

            /* Car 배열의 크기 만큼 반복 */
            if(cars[i].position > mostGoValue){

                /* i번째 전진 횟수를 이전과 비교하여 클경우  */
                mostGoValue = cars[i].position;                      // 최대 전진횟수 값 변경
            }
        }

        for(int i=0;i<cars.length;i++){

            /* Car배열의 크기 만큼 반복 */
            if(cars[i].position == mostGoValue){

                /* 최대 전진 횟수 하고 같을 경우 */
                cars[SET].firstCarName.add(cars[i].name);            // SET 위치의 ArrayList에 저장
            }
        }

        System.out.println(String.join(",",cars[SET].firstCarName) + "가 최종 우승 했습니다");
    }
}