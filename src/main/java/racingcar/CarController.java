package racingcar;

public class CarController {
    private int carAmount;
    private Car[] cars;

    public CarController(String[] names) {
        this.carAmount = names.length;
        cars = new Car[carAmount];
        makeCarInstance(names);
    }

    private void makeCarInstance(String[] names) {
        for (int i = 0; i < carAmount; i++) {
            cars[i] = new Car(names[i]);
        }
    }

    public void makeMove() {
        System.out.println("실행 결과");
        for (int i = 0; i < carAmount; i++) {
            cars[i].move();
            cars[i].print();
        }
        System.out.println();
    }


}
