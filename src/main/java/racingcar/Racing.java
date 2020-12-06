package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utils.InputUtils;
import utils.PrintUtils;

/**
 * Racing 게임을 진행하는 클래스
 *
 * @author  483759@naver.com / 윤이진
 * @version 1.0 2020/12/05
 */
public class Racing {

    private static List<Car> carList;
    private static int gameNumber;

    private static InputUtils inputUtils;
    private static PrintUtils printUtils;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        inputUtils = new InputUtils();
        printUtils = new PrintUtils();

        setCarList();
        setGameNumber();
        printUtils.printGameResultMessage();
        for (int i = 0; i < gameNumber; i++) {
            carRacing();
        }
        printUtils.printWinners(whichCarsWin());
    }

    /* 이름 리스트를 받아서 Car 객체를 생성하는 메소드*/
    public static void setCarList() {
        carList = new ArrayList<>();

        printUtils.printInputNamesGuide();
        String[] nameList = inputUtils.inputCarsName();
        for (int i = 0; i < nameList.length; i++) {
            carList.add(new Car(nameList[i]));
        }
    }

    public static void setGameNumber(){
        printUtils.printInputNumberGuide();
        gameNumber = inputUtils.inputNumberOfGame();
    }

    /* 회차마다 차들의 경기를 진행하는 메소드 */
    public static void carRacing() {
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).movePosition();
        }
        printUtils.printCarsPosition(carList);
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

}
