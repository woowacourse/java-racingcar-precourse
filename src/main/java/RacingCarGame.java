import domain.*;

import java.util.ArrayList;

public class RacingCarGame {
    private RacingManager racingManager;
    private TrackingCenter trackingCenter;
    private DisplayBoard displayBoard;
    private ArrayList<Car> cars;
    private int totalTrial = 0;

    public RacingCarGame() {
        this.racingManager = new RacingManager();
        this.trackingCenter = new TrackingCenter();
        this.displayBoard = new DisplayBoard();
        this.cars = new ArrayList<Car>();
    }

    public void setCars() {
        this.cars = this.racingManager.initializeCars();
    }

    public void setTotalTrial() {

    }

    public void start() {

    }

    public static void main(String args[]) {
        RacingCarGame racingCarGame = new RacingCarGame();

        racingCarGame.setCars();
        racingCarGame.setTotalTrial();
        racingCarGame.start();
    }
}