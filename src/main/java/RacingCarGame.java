import domain.*;

import java.util.ArrayList;

public class RacingCarGame {
    private RacingManager racingManager;
    private TrackingCenter trackingCenter;
    private DisplayBoard displayBoard;
    private ArrayList<Car> cars;

    public RacingCarGame() {
        this.racingManager = new RacingManager();
        this.trackingCenter = new TrackingCenter();
        this.displayBoard = new DisplayBoard();
        this.cars = new ArrayList<Car>();
    }

    public static void main(String args[]) {
        RacingCarGame racingCarGame = new RacingCarGame();

    }
}