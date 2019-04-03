package domain;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Car 클래스는 자동차 게임에 관련된 모든 상태를 나타내는 클래스 입니다.
 *
 * @version 2019년 3월 30일
 * @author 이중혁
 */

public class Car {
    private final String name;
    private int position = 0;
    private ArrayList<String> saveCarResult = new ArrayList<String>();                  // 진행도를 입력받는 ArrayList
    private static final int RAMDOM_NUMBER_MAX = 10;                                     // 난수 범위
    private static int SET = 0;

    public Car(String name) {
        this.name = name;
    }

    public static String getCarName() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        Scanner inputCarName = new Scanner(System.in);
        String checkCarName = inputCarName.nextLine();

        while(!separateCarNameState(checkCarName)){

            /* 입력받은 이름이 요구 조건(차이름은 5자이하)에 만족하지 않을경우 */
            checkCarName = inputCarName.nextLine();
        }

        return checkCarName;
    }

    /*(,) 를 기준으로 단어를 나눴을때 5자 이내 조건을 만족하는지 확인 하는 메소드*/
    public static boolean separateCarNameState(String checkCarName) {

        String[] carNameArray = checkCarName.split(",");         //매개변수를 (,)기준으로 구분후에 배열저장
        boolean carNameState = true;

        for (int i = 0; i < carNameArray.length; i++) {

            /*분리된 자동차 이름 배열 모두 확인 하기 위한 반복문*/
            if (carNameArray[i].length() > 5) {

                /*자동차 이름이 5자 초과일경우 */
                System.out.println("자동차 이름은 5자 이하 까지만 허용합니다");
                carNameState = false;                               // 자동차 이름 생성 불가
                break;
            }
        }
        return carNameState;
    }

    /*(,)를 기준으로 자동차 이름을 구분 하는 메소드*/
    public static String[] divideCarName(String getName) {

        String[] carNameArray = getName.split(",");             // (,)를 기준으로 분리 하여 배열저장

        return carNameArray;
    }

    /* 자동차 이름배열을 Car배열 각각에 인스턴스 생성과 동시에 초기화 하는 메소드 */
    public static Car[] inputCarName(String[] getCarNameArray){

        Car[] saveCarName = new Car[getCarNameArray.length];

        for(int i=0;i<getCarNameArray.length;i++){

            /* 분리된 이름배열을 Car배열 각각의 name에 인스턴스 생성과 동시에 name 변수 초기화 하는 반복문*/
            saveCarName[i] = new Car(getCarNameArray[i]);
        }

        return saveCarName;
    }

    public static int getRacingCarMove() {

        System.out.println("이동할 횟수를 입력해 주세요");

        Scanner racingCarMove = new Scanner(System.in);

        int carMoveNumber = racingCarMove.nextInt();

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

        if (randomNumber > 3) {

            /*난수의 값이 4이상 일 경우 */
            carState = true;
        }

        return carState;
    }

    /* 자동차 경주 과정을 저장하는 메소드  */
    public static void showDuringRace(Car[] saveCarName){

        for(int i=0;i<saveCarName.length;i++){

            /* Car배열의 크기 만큼 반복 */
            System.out.print(saveCarName[i].name + " : ");

            for(int j=0;j<saveCarName[i].saveCarResult.size();j++){

                /* Car배열 각각에 저장된 ArrayList 크기 만큼 반복 */
                System.out.print(saveCarName[i].saveCarResult.get(j));         // 저장된 ArrayList 출력
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }

    /* 자동차 경주 과정을 주는 메소드 */
    public static void saveDuringRacing(Car[] saveCarName){

        for(int i=0; i<saveCarName.length;i++){

            if(checkCarState(createRandomNumber()) == true){

                /* 생성된 난수의 범위가 4이상일때 */
                saveCarName[i].saveCarResult.add("-");                         // 자동차 전진 횟수 문자열 저장
                saveCarName[i].position++;
            }
        }
    }

    /* 가장 많이 전진한 횟수를 저장하는 메소드 */
    public static int setFinalWinnerCarName(Car[] saveCarName){

        int setFirstValue = saveCarName[0].position;

        for(int i=1;i<saveCarName.length;i++){

            /* Car배열의 크기 만큼 반복 */
            if(saveCarName[i].position>setFirstValue){

                /* i번째 전진 횟수를 이전과 비교하여 클경우  */
                setFirstValue = saveCarName[i].position;                        // 최대 전진횟수 값 변경
            }
        }
        return setFirstValue;
    }

    /* 공동 우승 차량 수를 반환하는 메소드 */
    public static int showWinnerSize(Car[] saveCarName, int saveFirstValue){

        int getWinnerCarNameSize = 0;

        for(int i=0;i<saveCarName.length;i++){

            /* Car배열의 크기 만큼 반복 */
            if(saveCarName[i].position == saveFirstValue){

                /* 최대 전진 횟수 하고 같을 경우 */
                getWinnerCarNameSize++;                                         // 공둥 우승 차량저장 변수 증가
            }
        }
        return getWinnerCarNameSize;
    }


    /* 공동 우승 차량  출력 */
    public static void showWinner(Car[] saveCarName, int saveFirstValue,int getWinnerCarNameSize) {

        String[] getWinnerCarName = new String[getWinnerCarNameSize];          // 공둥 우승 차량 문자열배열 선언

        for (int i = 0; i < saveCarName.length; i++) {

            /* Car 배열 크기 만큼 반복 */
            if (saveCarName[i].position == saveFirstValue) {

                /* 1등 전진 횟수와 같을 경우  */
                getWinnerCarName[SET] = saveCarName[i].name;                    // 문자열배열에 자동차 이름 저장
                SET++;
            }
        }

        System.out.println(String.join(",", getWinnerCarName) + "가 최종 우승 했습니다");
    }

    /* 실행 결과 문구 */
    public static void showResult(){

        System.out.println("실행 결과");
    }

}