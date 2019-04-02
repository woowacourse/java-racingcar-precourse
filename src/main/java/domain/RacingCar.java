/**
 * RacingCar 클래스는 자동차 경주를 하기 위한 클래스이다.
 * 구성 Method는 goRacing, receiveCarName, generateRandomNumber, 필요한 것들..?
 * Last modified: 2019.04.02
 * Author: SM Jeon
 */

package domain;

import java.util.*;

public class RacingCar {
    public static void main(String[] args) {
        goRacing();
    }

    /*
     * Method for Start Racing
     * Print Information and Receive car name, count
     */
    private static void goRacing() {
        Scanner s = new Scanner(System.in);
        int gameCount = 0;
        ArrayList<Car> carList = new ArrayList<Car>();

        carList = receiveCarName();
        System.out.println("시도할 회수는 몇회인가요?");
        gameCount = s.nextInt();
        System.out.println("실행 결과");
        for (int i = 0; i < gameCount; i++) {
            for (int j = 0; j < carList.size(); j++) {
                printOneResult(carList.get(j));
            }
            System.out.println();
        }
        //printAllResult();                    // 결과 출력: 우승자1, 우승자2 가 최종 우승했습니다.
    }

    /*
     * Method for receive Car Name
     * 차의 이름을 사용자로부터 받는다. ","를 기준으로 이름을 나누어 ArrayList에 저장하고 최종 List를 return한다.
     * 이름은 5자 이하여야 한다.
     */
    private static ArrayList<Car> receiveCarName() {
        Scanner s = new Scanner(System.in);
        ArrayList<Car> carList = new ArrayList<Car>();
        String nameLine;
        String[] nameList;
        int nameCount = 0;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        nameLine = s.nextLine();

        nameList = nameLine.split(",");
        for (String name : nameList) {
            if (name.length() > 5) {
                System.out.println("자동차의 이름은 5자까지만 허용합니다. 다시 입력해주세요.");
                return receiveCarName();
            }
            Car tempCar = new Car(name);
            carList.add(tempCar);
        }
        return carList;
    }

    private static void printOneResult(Car car) {
        int randomNumber = 5;
        //randomNumber = generateRandomNumber(); 구현 필요.
        System.out.print(car.getCarName() + " : ");
        if (randomNumber >= 4) {
            car.addOnePosition();
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
        }
        System.out.println();
    }
}
