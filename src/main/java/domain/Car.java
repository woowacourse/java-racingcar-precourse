
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
    private ArrayList<String> saveCarResult = new ArrayList<String>();
    private static int RAMDOM_NUMBER_MAX = 10;
    private static int SET = 0;

    public Car(String name) {
        this.name = name;
    }

    public static String getCarName() {
        Scanner inputCarName = new Scanner(System.in);
        String checkCarName = inputCarName.nextLine();

        if(separateCarNameState(checkCarName) == false){

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

        String[] carNameArray = getName.split(",");

        return carNameArray;
    }
    public static Car[] inputCarName(String[] getCarNameArray){

        Car[] saveCarName = new Car[getCarNameArray.length];
        for(int i=0;i<getCarNameArray.length;i++){
            saveCarName[i] = new Car(getCarNameArray[i]);
        }
        System.out.println("실행 결과");
        return saveCarName;
    }
    public static int getRacingCarMove() {

        System.out.println("이동할 횟수를 입력해 주세요");

        Scanner racingCarMove = new Scanner(System.in);
        int carMoveNumber = racingCarMove.nextInt();

        return carMoveNumber;
    }

    public static int createRandomNumber() {

        Random getRandomNumber = new Random();

        int randomNumber = getRandomNumber.nextInt(RAMDOM_NUMBER_MAX);
        return randomNumber;
    }

    public static boolean checkCarState(int randomNumber) {

        boolean carState = false;

        if (randomNumber > 3) {

            /*난수의 값이 4이상 일 경우 */
            carState = true;
        }

        return carState;
    }

    public static void showDuringRace(Car[] saveCarName){


        for(int i=0;i<saveCarName.length;i++){

            System.out.print(saveCarName[i].name + " : ");

            for(int j=0;j<saveCarName[i].saveCarResult.size();j++){
                System.out.print(saveCarName[i].saveCarResult.get(j));
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }
    public static void saveDuringRacing(Car[] saveCarName){

        int saveRandom = 0;
        for(int i=0; i<saveCarName.length;i++){

            saveRandom = createRandomNumber();

            if(checkCarState(saveRandom) == true){
                saveCarName[i].saveCarResult.add("-");
                saveCarName[i].position++;
            }
        }
    }

    public static void getRacingCarName() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
    }

    public static int setFinalWinnerCarName(Car[] saveCarName){

        int setFirstValue = saveCarName[0].position;

        for(int i=1;i<saveCarName.length;i++){

            if(saveCarName[i].position>setFirstValue){
                setFirstValue = saveCarName[i].position;
            }
        }
        return setFirstValue;
    }

    public static int showWinnerSize(Car[] saveCarName, int saveFirstValue){

        int getWinnerCarNameSize = 0;

        for(int i=0;i<saveCarName.length;i++){
            if(saveCarName[i].position == saveFirstValue){
                getWinnerCarNameSize++;
            }
        }
        return getWinnerCarNameSize;
    }

    public static void showWinner(Car[] saveCarName, int saveFirstValue,int getWinnerCarNameSize){

        String[] getWinnerCarName = {,};

        getWinnerCarName = new String[getWinnerCarNameSize];
        for(int i=0;i<saveCarName.length;i++){
            if(saveCarName[i].position == saveFirstValue){
                getWinnerCarName[SET] = saveCarName[i].name;
                SET++;
            }
        }
        System.out.println(String.join(",",getWinnerCarName) + "가 최종 우승 했습니다");
    }


}