package domain;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static private ArrayList<Car> cars;
    static private int turns;
    static private Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        cars = new ArrayList<>();

        boolean pass = makeCars();
        if (!pass) {
            System.out.println("정상적이지 않은 이름이 확인되었습니다. 게임을 종료합니다.");
            return;
        }

        setTurnsCount();
        if (turns < 1) {
            System.out.println("정상적이지 않은 회수가 확인되었습니다. 게임을 종료합니다.");
            return;
        }

        play();

        showResult();
    }

    // 자동차 인스턴스 생성 관련 메소스들
    static private boolean makeCars() {
        String allCarsName;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n각 자동차 이름은 1자 이상, 5자 이하만 가능합니다.");
        allCarsName = sc.nextLine();
        String[] splittedNames = allCarsName.split(",");
        for (String name : splittedNames) {
            boolean validName = isValidName(name);
            if (!validName) return false;
            addCarToList(cars, name);
        }
        return true;
    }

    static private boolean isValidName(String name) {
        return (name.length() > 0 && name.length() <= 5);
    }

    static private void addCarToList(ArrayList<Car> cars, String name) {
        Car car = new Car(name);
        cars.add(car);
    }

    // 턴 수 세팅 관련 메소드들
    static private void setTurnsCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        turns = sc.nextInt();
    }

    // 게임 진행 관련 메소드들
    static private void play() {
        System.out.println("실행 결과");
        while (turns > 0) {
            turnEachCars();
            System.out.println();
            turns -= 1;
        }
    }

    static private void turnEachCars() {
        for (Car car : cars) {
            car.useTurn();
        }
    }

    // 결과 출력 관련 메소드들
    static private void showResult() {
        ArrayList<Car> winners = collectWinnsers();
        ArrayList<String> winnersName = collectNames(winners);
        System.out.println(String.join(", ", winnersName) + "가 최종 우승했습니다.");
    }

    static private ArrayList<Car> collectWinnsers() {
        ArrayList<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            addToWinnersIfHeadPosition(car, winners);
        }
        return winners;
    }

    static private void addToWinnersIfHeadPosition(Car car, ArrayList<Car> winners) {
        if (car.isHead()) winners.add(car);
    }

    static private ArrayList<String> collectNames(ArrayList<Car> winners) {
        ArrayList<String> winnersName = new ArrayList<>();
        for (Car car: winners) {
            winnersName.add(car.getName());
        }
        return winnersName;
    }
}
