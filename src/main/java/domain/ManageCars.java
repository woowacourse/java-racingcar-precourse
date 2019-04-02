package domain;

public class ManageCars {
    private Car[] car;

    public ManageCars(String[] carNames) {
        createCars(carNames);
    }

    /**
     * car 객체 생성(name 개수 만큼)
     * @param carNames  : car's name 을 저장한 String 배열
     */
    public void createCars(String[] carNames) {
        for(int i = 0; i < carNames.length; i++) {
            car[i] = new Car(carNames[i]);
        }
    }
}
