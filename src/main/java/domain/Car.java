package domain;

import java.util.*;
import java.util.stream.Collectors;

public class Car {
    private final String name;
    private static int moveTimes;
    private static List<Car> carList;
    private int position = 0;
    public static Random random = new Random();

    public Car(String name) {
        this.name = name;
    }

    public int getPosition() { return this.position; }

    static public void enterCarName() {
        String carName[];
        Scanner scan = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        /* 쉼표로 구분 된 이름들을 carList에 추가 */
        carName = scan.nextLine().split(",");
        carList = new ArrayList<>();
        for (String token  :carName) {
            carList.add(new Car(token));
        }
    }

    static public void enterHowManyTime() {
        Scanner scan = new Scanner(System.in);
        System.out.println("시도할 회수는 몇회인가요?");
        moveTimes = scan.nextInt();
    }

    public static int move() {
        //0에서 9사이 random, 4이상 전진, 3이하 그대로
        int moveOrStop = random.nextInt(10);
        if(moveOrStop >= 4) {
            return 1;
        }
        return 0;
    }
    public void printNameAndPosition() {
        System.out.print(name+":");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    static public void moveAndPrint() {
        for (Car c  : carList) {
            c.position += move();
            c.printNameAndPosition();
        }
    }

    static public void playRacingCar() {
        System.out.println("실행 결과");
        /* 실행 */
        for (int i = 0; i < moveTimes; i++) {
            moveAndPrint();
            System.out.println();
        }
    }


    static public void printWinner() {
        /* 우승자 판단 */
        List<String> winnersList;
        int winnersPosition = carList.stream()
                        .max(Comparator.comparing(Car::getPosition)).get().getPosition();

        winnersList = carList.stream()
                .filter(c -> c.getPosition() == winnersPosition)
                .map(c -> c.name)
                .collect(Collectors.toList());

        String winner = String.join(",", winnersList);

        System.out.println(winner+"가 최종 우승했습니다.");
    }


    public static void main(String[] args) {
        Car.enterCarName();
        Car.enterHowManyTime();
        Car.playRacingCar();
        Car.printWinner();
    }

    // 추가 기능 구현
}
