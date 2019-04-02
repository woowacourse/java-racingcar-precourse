package domain;

public class Car implements Comparable<Car> {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    /*
     * 랜덤값에 따라 position을 1만큼 증가시키거나 변화를 주지 않는 함수
     */
    public void chooseGoOrStop() {
        int random = (int) (Math.random() * 10);
        if (random > 4)
            position++;
    }

    /*
     * descending order
     */
    @Override
    public int compareTo(Car car) {
        return car.position - this.position;
    }

}
