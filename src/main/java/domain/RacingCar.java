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
     * Print each result, and total result
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
        //printWinner(carList);
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

    /*
     * Method for One Car Instance
     * 0에서 9 사이의 Random Number를 만들어 해당 숫자가 4이상일 경우 한칸 전진(position 값 +1), 아닐 경우 멈춘다.(아무것도 안함)
     * 현재까지의 각 Car 객체의 position 값을 받아와서 개수 만큼 - 출력한다.
     */
    private static void printOneResult(Car car) {
        int randomNumber = generateRandomNumber();

        System.out.print(car.getCarName() + " : ");
        if (randomNumber >= 4) {
            car.addOnePosition();
        }
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /*
     * Method for Generate Random Number
     * numList에 0부터 9까지 List를 담아놓은후 shuffle method를 이용해 randomize 한다.
     * shuffle된 list의 index 0번째 값을 return 한다.
     */
    private static int generateRandomNumber() {
        List<Integer> numList = new ArrayList<Integer>();       // 0 to 9 number List
        for(int i = 0; i < 10; i++) {
            numList.add(i);
        }
        Collections.shuffle(numList);
        return numList.get(0);
    }

    /*
     * Method for getting max position value
     * 최종 우승자를 알아내기 위해 최종 우승자의 position 값을 return 한다.
     */
    private static int getMaxPosition(ArrayList<Car> carList) {
        int max = 0;
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getPosition() >= max) {
                max = carList.get(i).getPosition();
            }
        }
        return max;
    }

    /*
     * Method for get Winner's name
     * getMaxPosition 사용 하여 최종 승자의 name list를 return 한다.
     */
    private static List<String> getWinner(ArrayList<Car> carList) {
        int max = getMaxPosition(carList);
        List<String> winnerList = new ArrayList<String>();
        for (int i = 0; i < carList.size(); i++) {
            if (max == carList.get(i).getPosition()) {
                winnerList.add(carList.get(i).getCarName());
            }
        }
        return winnerList;
    }

}
