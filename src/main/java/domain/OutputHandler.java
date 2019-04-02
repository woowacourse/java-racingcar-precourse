package domain;

import java.util.List;
import java.util.ListIterator;

public class OutputHandler {

    void printCarPosition(Car car) {
        System.out.println(car.getName() + ": " + car.getPosition());
    }

    void printWinner(List<Car> winnerCars) {
        ListIterator<Car> listIterator = winnerCars.listIterator();
        String result = listIterator.next().getName();
        while (listIterator.hasNext()) {
            result += ", " + listIterator.next().getName();
        }
        System.out.println("\n" + result + "가 최종 우승했습니다.");
    }

    void printUnexpectedInput() {
        System.out.println("잘못된 입력입니다.");
    }
}
