import domain.*;

import java.util.ArrayList;

public class RacingCarGame {
    private RacingManager racingManager;
    private TrackingCenter trackingCenter;
    private ArrayList<Car> cars;
    private int totalTrial = 0;

    public RacingCarGame() {
        this.racingManager = new RacingManager();
        this.trackingCenter = new TrackingCenter();
        this.cars = new ArrayList<Car>();
    }

    public void setCars() {
        this.cars = this.racingManager.getInitializedCars();
    }

    public void setTotalTrial() {
        this.totalTrial = this.racingManager.getTotalTrial();
    }

    public void start() {
        for (int trial = 1; trial <= totalTrial; trial++) {
            this.racingManager.sendMoveSignals(cars);
            this.trackingCenter.detectPositions(cars);
            this.trackingCenter.showPositions();
            this.trackingCenter.showRanks();
        }
        this.trackingCenter.showWinners();
    }

    public static void main(String args[]) {
        RacingCarGame racingCarGame = new RacingCarGame();

        racingCarGame.setCars();
        racingCarGame.setTotalTrial();
        racingCarGame.start();
    }
}