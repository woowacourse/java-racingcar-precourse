package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TrackingCenter {
    private HashMap<String, Integer> realTimePositionsOfCars = new HashMap<String, Integer>();

    public void detectPositions(ArrayList<Car> cars) {
        for (Car car: cars) {
            realTimePositionsOfCars.put(car.getName(), car.getPosition());
        }
    }

    public String repeat(String str, int repeatTime) {
        StringBuffer repeated = new StringBuffer();

        for (int i = 0; i < repeatTime; i++) {
            repeated.append(str);
        }
        return repeated.toString();
    }

    /**
     * 각 자동차의 이름과 위치를 출력해주는 메소드입니다.
     * reaTimePositionsOfCars가 {"car1" : 2, "car2" : 3, "car3" : 1} 인 경우
     * 출력 예시 :
     * car1 : --
     * car2 : ---
     * car3 : -
     */
    public void showPositions() {
        for (Map.Entry<String, Integer> position: this.realTimePositionsOfCars.entrySet()) {
            System.out.print(position.getKey() + " : ");
            System.out.println(repeat("-", position.getValue()));
        }
        System.out.print("\n");
    }

    public void showRanks() {

    }

    public String pickWinners(HashMap<String, Integer> positionsOfCar) {
        int maxPosition = 0;
        StringBuffer winners = new StringBuffer();

        for (Map.Entry<String, Integer> positionOfCar: positionsOfCar.entrySet()) {
            if (positionOfCar.getValue() > maxPosition) {
                winners = new StringBuffer().append(positionOfCar.getKey());
                maxPosition = positionOfCar.getValue();
            } else if (positionOfCar.getValue() == maxPosition) {
                winners.append(", " + positionOfCar.getKey());
            }
        }
        return winners.toString();
    }

    public void showWinners() {
        String winners = pickWinners(this.realTimePositionsOfCars);

        System.out.println(winners + "(이)가 최종 우승했습니다.");
    }
}