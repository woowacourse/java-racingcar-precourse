package racingcar;

public class Race {
    public static final int TRY_TIMES_MIN = 1;
    
    private Player player;
    private Car[] cars;
    private int tryTimes;
    
    public Race(Player player) {
        this.player = player;
    }
    
    public void setUp() {
        setUpCars();
        setUpTryTimes();
    }
    
    private void setUpCars() {
        String[] carNames = this.player.carNamesInput();
        
        this.cars = new Car[carNames.length];
        for (int i = 0; i < this.cars.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
    }
    
    private void setUpTryTimes() {
        this.tryTimes = this.player.tryTimesInput();
    }
}
