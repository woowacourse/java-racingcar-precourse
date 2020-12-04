package racingcar;

public class Race {
    private Player player;
    private Car[] cars;
    
    public Race(Player player) {
        this.player = player;
    }
    
    public void setUp() {
        setUpCars();
    }
    
    private void setUpCars() {
        String[] carNames = this.player.carNamesInput();
        
        this.cars = new Car[carNames.length];
        for (int i = 0; i < this.cars.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
    }
}
