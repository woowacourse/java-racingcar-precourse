package racingcar;

public class CarController {
    public int carAmount;
    public Car[] cars;

    public CarController(String[] names) {
        this.carAmount = names.length;
        cars = new Car[carAmount];
        makeCarInstance(names);
    }

    private void makeCarInstance(String[] names) {
        for (int i = Constant.ZERO; i < carAmount; i++) {
            cars[i] = new Car(names[i]);
        }
    }

    public void makeMove() {
        System.out.println("실행 결과");
        for (int i = Constant.ZERO; i < carAmount; i++) {
            cars[i].move();
            cars[i].print();
        }
        System.out.println();
    }
}
