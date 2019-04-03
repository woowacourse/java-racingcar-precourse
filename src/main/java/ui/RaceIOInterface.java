package ui;

import domain.Track;

/**
 * @author delf
 */
public interface RaceIOInterface {
    String[] inputRacersName(String helpMessage);

    int inputNumber(String helpMessage);

    void showTrack(Track track);

    void showWinner(Track track);
}
