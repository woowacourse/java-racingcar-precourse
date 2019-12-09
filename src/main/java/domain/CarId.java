package domain;

class CarId {
    private static CarId instance = null;
    private int id = RacingGameConfig.DEFAULT_ID;

    private CarId() {}

    static CarId getInstance() {
        if (instance == null) {
            instance = new CarId();
        }

        return instance;
    }

    int increaseId() {
        id += RacingGameConfig.AMOUNT_INCREASE_ID;
        return id;
    }
}
