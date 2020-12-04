package racingcar;

import utils.RandomUtils;

import java.util.ArrayList;

/* 입력 값들 예외처리 후 받아오기 완료.

 * <앞으로 해야할 일>
 * 1. Game Round 별로 Game play
 * 2. Random값 받아와서 forwardPosition() 수행
 * 3. 하드코딩 된 부분 찾아서 상수화(static final) 시키기
 * 4. AskQuestion.java를 분할하고 싶다 !!!!!
 * 5. 변수명에 불용어 찾아보고 대체하기
 * 6. README에 예외 상황 추가 및 input/output 관련된 내용은 삭제해야 하나..?
 * 7. 같은 클래스 내에서 변수 접근할 때 getter, setter로 불필요하게 접근하지 않았는지?
 * 8. 하나의 클래스를 지켜보며 단일 책임 원칙을 지키고 있는지 생각해보자.
 * 9. 패키지 이동이 있을 경우를 대비해서 접근지정자도 한 번 검토를 해보자.
 * 10. 기능 목록에 작성한 단위로 구현 후 commit을 해야하는데 하지 못했다. 3주차+오프라인 때는 꼭 지킬 것.
 * 11. 영어로 commit message를 작성하니 정확한 의미 전달을 못하는 것 같음. 이후로는 한글로 정확히 작성할 것.
 * 12. 0이라도 하드코딩 하지말자. 상수화 해주자.
 * 13. AskQuestion.java에 출력 구문을 함수화 했는데, 한 줄 짜리라면 굳이 안해도 될 듯?
 */

public class GameManager {

    public static final int MIN_RANDOM_VALUE = 0;
    public static final int MAX_RANDOM_VALUE = 9;
    public static final int BOUNDARY_OF_TOGGLE = 3;

    private int numberOfTry = 0;
    private int winnerPosition = 0;
    private ArrayList<Car> carList = new ArrayList<>();

    public GameManager(String[] names, int numberOfTry) {
        for (String name : names) {
            carList.add(new Car(name));
        }
        this.numberOfTry = numberOfTry;
    }

    public void gameStart() {
        System.out.println("\n실행결과");
        for (int round = 0; round < numberOfTry; round++) {
            playRound();
        }
        printWinners();
    }
    
    public void playRound() {
        for (Car car : carList) {
            if (keepGoing()) {
                car.forwardPosition();
                updateWinnerPosition(car);
            }
        }
        printResultOfRound();
    }

    public boolean keepGoing() {
        int randomNumber = RandomUtils.nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
        return randomNumber > BOUNDARY_OF_TOGGLE;
    }

    public void printResultOfRound() {
        for (Car car : carList) {
            System.out.print(car.getName() + " : ");
            printStatusBar(car);
        }
        System.out.println();
    }

    public void printStatusBar(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void updateWinnerPosition(Car car) {
        if (winnerPosition < car.getPosition()) {
            winnerPosition = car.getPosition();
        }
    }

    public void printWinners() {
        int carListSize = carList.size();
        boolean printedFirstWinner = false;
        System.out.print("최종 우승자: ");
        for (int i = 0; i < carListSize; i++) {
            if (carList.get(i).getPosition() == winnerPosition) {
                printWinnerNames(i, printedFirstWinner);
                printedFirstWinner = true;
            }
        }
    }

    public void printWinnerNames(int index, boolean printedFirstWinner) {
        if (printedFirstWinner) {
            System.out.print(", ");
        }
        System.out.print(carList.get(index).getName());
    }

}
