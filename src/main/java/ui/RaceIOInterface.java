package ui;

import domain.Track;

/**
 * @author delf
 */
public interface RaceIOInterface {
    String[] inputRacersName();

    int inputTryNumber();

    void showTrack(Track track);

    void showWinner(Track track);

    static void showPlaneText(String s) {
        System.out.println(s);
    }
}
