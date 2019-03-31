
package domain;
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

    public Car(String name) {
        this.name = name;
    }

    public static String getCarName(){

        Scanner inputCarName = new Scanner(System.in);
        Car carName = new Car(inputCarName.nextLine());

        return carName.name;
    }

    /*(,) 를 기준으로 단어를 나눴을때 5자 이내 조건을 만족하는지 확인 하는 메소드*/
    public static boolean separateCarNameState(String carName){

        String[] carNameArray = carName.split(",");         //매개변수를 (,)기준으로 구분후에 배열저장

        boolean carNameState = true;

        for(int i=0;i<carNameArray.length;i++){

            /*분리된 자동차 이름 배열 모두 확인 하기 위한 반복문*/
            if(carNameArray[i].length()>5){

                /*자동차 이름이 5자 초과일경우 */
                System.out.println("자동차 이름은 5자 이하 까지만 허용합니다");
                carNameState = false;                               // 자동차 이름 생성 불가
                break;
            }
        }
        return carNameState;
    }

    /*(,)를 기준으로 자동차 이름을 구분 하는 메소드*/
    public static String[] divideCarName(String carName){

        String[] carNameArray = carName.split(",");

        return carNameArray;
    }

    public static int getRacingCarMove(){

        Scanner racingCarMove = new Scanner(System.in);
        int carMoveNumber = racingCarMove.nextInt();

        return carMoveNumber;
    }

    public static int createRandomNumber(){

        Random getRandomNumber = new Random();

        int randomNumber = getRandomNumber.nextInt(10);

        return randomNumber;
    }

    public static boolean checkCarState(int randomNumber){

        boolean carState = false;

        if(randomNumber>3){

            /*난수의 값이 4이상 일 경우 */
            carState = true;
        }

        return carState;
    }


}
