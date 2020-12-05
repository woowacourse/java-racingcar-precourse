package racingcar;

import java.util.ArrayList;

public class Winners {
    private int position;
    private ArrayList<Car> cars;

    public Winners() {
        this.position = -1;
        this.cars = new ArrayList<Car>();
    }

    public Winners(Car car) {
        setWinners(car);
    }

    // 입력받은 자동차와 비교하여 우승자들의 정보를 갱신한다.
    public void updateWinners(Car car) {
        int carPosition = car.getPosition();
        if (this.getPoisition() == carPosition) {
            // 최대값일 경우 우승자 리스트에 추가한다.
            this.addWinner(car);
            return;
        }
        if (this.getPoisition() < carPosition) {
            // 현재 최대값보다 더 멀리간 자동차가 있을 경우 최대값을 갱신하고 우승자 리스트를 새로 만든다.
            this.setWinners(car);
        }
    }

    // 입력받은 자동차를 우승자로 설정한다.
    private void setWinners(Car car) {
        this.position = car.getPosition();
        this.cars = new ArrayList<Car>();
        cars.add(car);
    }

    public void addWinner(Car car) {
        cars.add(car);
    }

    public int getPoisition() {
        return position;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }
}
