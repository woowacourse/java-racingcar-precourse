package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utils.InputUtils;

/**
 * Racing 게임을 진행하는 클래스
 *
 * @author  483759@naver.com / 윤이진
 * @version 1.0 2020/12/05
 */
public class Racing {

    private static List<Car> carList;
    private static int gameNumber;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final InputUtils inputUtils = new InputUtils();

        String[] nameList = inputUtils.inputCarsName();
        setCarList(nameList);
        gameNumber = inputNumberofGame(scanner);
        for(int i=0;i<gameNumber;i++){
            carRacing();
        }
        printWinners(whichCarsWin());
        // TODO 구현 진행
    }

    /* 이름 리스트를 받아서 Car 객체를 생성하는 메소드*/
    public static void setCarList(String[] nameList) {
        carList = new ArrayList<>();
        for (int i = 0; i < nameList.length; i++) {
            carList.add(new Car(nameList[i]));
        }
    }

    /* 회차마다 차들의 경기를 진행하는 메소드 */
    public static void carRacing() {
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).movePosition();
        }
        printCarsPosition();
        System.out.println("");
    }

    /* 차량들의 전진 상황을 출력하는 메소드 */
    public static void printCarsPosition(){
        System.out.println("\n실행 결과");
        for(int i=0;i<carList.size();i++){
            System.out.printf(carList.get(i).getName()+" : ");
            carList.get(i).printPosition();
            System.out.println("");
        }
    }

    /* 어떤 차들이 우승했는지 계산하는 메소드*/
    public static List<String> whichCarsWin() {
        int maxPosition = 0;
        List<String> winnerList = new ArrayList<>();
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getPosition() > maxPosition) {
                maxPosition = carList.get(i).getPosition();
            }
        }
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getPosition() == maxPosition) {
                winnerList.add(carList.get(i).getName());
            }
        }
        return winnerList;
    }

    /* 우승한 차들의 이름을 출력하는 메소드 */
    public static void printWinners(List<String> winnerList) {
        System.out.printf("최종 우승자: " + String.join(", ", winnerList));
    }
}
