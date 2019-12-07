/*
 * Compare
 *
 * ver 1.0
 *
 * 2019.12.07
 *
 * CopyRight
 *
 */
package domain;

import java.util.ArrayList;
import java.util.Comparator;

public class Compare {
    /*
     * Compare 클래스 입니다.
     * 게임에 대한 결과를 계산하고 출력하는 클래스입니다.
     */
    public static void showAll(int tryChance, ArrayList<Car> carList) { // 진행 결과 및 결과를 출력시켜주는 메소드 입니다.
        System.out.println("실행 결과");
        for (int move =0; move < tryChance; move++) {
            moveAll(carList);
            printProgress(carList);
        }
        Compare.printResult(carList);
    }

    public static void moveAll(ArrayList<Car> carList) { // Car객체들을 움직여주는 메소드 입니다.
        for (Car carindex : carList) {
            carindex.moveToCar();
        }
    }

    public static void printProgress(ArrayList<Car> carList) { // 모든 Car객체의 진행상황을 출력하는 메소드 입니다.
        for (Car carindex : carList) {
            carindex.progressOfCar();
        }
        System.out.print("\n");
    }

    public static void  printResult(ArrayList<Car> carList) { // 최종적으로 누가 승리하였는지를 출력하는 메소드 입니다.
        String result = getResult(carList);
        result += "가최종우승했습니다.";
        System.out.println(result);
    }

    public static String getResult(ArrayList<Car> carList) { // 최정결과를 계산해주는 함수입니다.
        String result = "";
        String temp_result;
        carList.sort(Comparator.naturalOrder()); // ArrayList를 posiotn 기준으로 오름차순으로 정렬시켜줍니다.
        for (int index = 0; index < carList.size(); index++) {
            temp_result = compareResult(index,carList);
            if (temp_result == "") { // 만약 결과값이 다음과 같으면 값이 동일한 최대값이 없음을 의미하므로 반복문을 종료합니다.
                break;
            } else {
                result += temp_result; // 동일한 값의 최대값을 다수로 가질수 있음으로 계속 더해줍니다.
            }
        }
        return result;
    }

    public static String compareResult(int index, ArrayList<Car> carList) { // 최대값을 비교해주는 메소드 입니다.
        String result;
        if (index == 0) { // 처음값은  ',' 를 붙이면 안되기 때문에 따로 조건문으로 검사합니다
            result = carList.get(index).getName();
            return result;
        } else if (carList.get(index-1).getPosition() == carList.get(index).getPosition()) { // 만약 전의 값과 현재 값이 동일한 경우 같은 최대값임으로 그 객체의 이름을 반환합니다.
            result = ',' + carList.get(index).getName();
            return result;
        } else { // 값이 다르면 아무것도 없는 문자열을 반환합니다.
            result = "";
            return result;
        }
    }

}
