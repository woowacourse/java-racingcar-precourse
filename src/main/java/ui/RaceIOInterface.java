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
}
