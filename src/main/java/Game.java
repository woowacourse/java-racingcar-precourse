/**
 * Precourse 2주차
 * Game.java
 * Purpose: 사용자로부터 받은 입력을 통해 자동차 인스턴스를 생성하고, 레이싱 게임을 수행한다.
 *
 * @version         1.00 12/3/2019
 * @author          김태헌
 */
import java.util.Scanner;

public class Game {
    static Scanner s = new Scanner(System.in);

    /**
     * The entry point of application
     *
     * @param args are not used
     */
    public static void main(String[] args) {
        Car[] cars;
        String[] names;
        int numberOfGames;

        names = processInputText();     // 입력문자열을 comma 로 split
        if (names == null) {

            /* 사용자로부터 입력받은 자동차 이름의 길이가 5가 넘는 경우 프로그램 종료 */
            return;
        }
        System.out.println("시도할 회수는 몇회인가요?");
        numberOfGames = s.nextInt();
        cars = initializeCar(names);       // Car array 초기화
        printGame(cars, numberOfGames, names.length);   // game 내용을 출력
    }

    /**
     * 사용자로부터 문자열을 입력받고, comma 로 split 한 뒤, 길이가 5보다 크면 null 을,
     * 5 이하이면 문자열 배열을 return 해준다.
     *
     * @return 입력받은 문자열을 comma 단위로 split 한 String array
     */
    public static String[] processInputText() {
        String input;
        String[] names;

        System.out.println("경주할 자동차 이름을 입력하세요, (이름은 쉼표(,) 기준으로 구분)");
        input = s.nextLine();
        names = input.split(",");
        for (String name : names) {
            if (name.length() > 5) {

                /* 각 자동차 이름의 길이가 5가 넘는 경우 에러문장 출력 */
                System.out.println("자동차 이름은 5자 이하가 되어야 합니다.");
                return null;
            }
        }
        return names;
    }

    /**
     * 자동차 배열을 주어진 입력에 맞게 초기화 해준다.
     *
     * @param names         : 자동차의 이름 배열
     */
    public static Car[] initializeCar(String[] names) {
        Car[] cars = new Car[names.length];
        for (int i = 0; i < names.length; i++) {
            cars[i] = new Car(names[i]);
        }
        return cars;
    }

    /**
     * 게임을 진행하고 출력 형식에 맞게 게임 내용을 출력해준다.
     * @param cars          : 게임에 참여하는 Car array
     * @param numberOfGames : 게임 횟수
     * @param numberOfCars  : 게임에 참여하는 Car 갯수
     */
    public static void printGame(Car[] cars, int numberOfGames,
                                 int numberOfCars) {

        /* 게임 진행 결과 출력 */
        System.out.println("\n실행 결과");
        for (int i = 0; i < numberOfGames; i++) {
            for (int j = 0; j < numberOfCars; j++) {
                cars[j].printMovingForward();
            }
        }
        printWinner(cars);
    }

    /**
     * 각 자동차의 움직인 거리를 통해 우승자를 가려내고, 출력 형식에 맞게 우승자를 출력해준다.
     *
     * @param cars          : 게임에 참여하는 Car array
     */
    public static void printWinner(Car[] cars) {
        int maxMovingCounter = 0;
        String winners = "";

        for (int i = 0; i < cars.length; i++) {
            int position = cars[i].getPosition();

            /* 가장 많이 움직인 거리를 찾는다 */
            if (position > maxMovingCounter) {
                maxMovingCounter = position;
            }
        }
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getPosition() == maxMovingCounter) {

                /* 가장 많이 움직인 자동차들의 이름을 문자열로 저장한다 */
                winners += cars[i].getName() + ", ";
            }
        }
        System.out.println(winners.substring(0, winners.length() - 2) + "가 최종"
                + " 우승했습니다.");
    }
}