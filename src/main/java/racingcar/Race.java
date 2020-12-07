package racingcar;

import java.util.ArrayList;

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
    
    public void run() {
        player.printStartResult();
        for (int i = 0; i < this.tryTimes; i++) {
            runOneTry();
        }
        player.printWinners(judgeWinners(cars));
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
    
    private void runOneTry() {
        for (Car car : this.cars) {
            car.tryMoveForward();
        }
        player.printCarsStatus(this.cars);
    }
    
    private Car[] judgeWinners(Car[] cars) {
        ArrayList<Car> winnerList = new ArrayList<Car>();
        int positionWinner = Car.POSITION_START;
        
        for (Car car : cars) {
            positionWinner = refreshWinner(winnerList, car, positionWinner);
        }
        
        return winnerList.toArray(new Car[winnerList.size()]);
    }
    
    private int refreshWinner(ArrayList<Car> winnerList, Car carCurrent, int positionWinner) {
        int positionCarCurrent = carCurrent.getPosition();
        
        if (positionCarCurrent < positionWinner) {
            return positionWinner;
        }
        if (positionCarCurrent > positionWinner) {
            winnerList.clear();
        }
        
        winnerList.add(carCurrent);
        return positionCarCurrent;
    }
}
