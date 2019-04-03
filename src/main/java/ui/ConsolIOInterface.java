package ui;

import domain.Track;

/**
 * @author delf
 */
public class ConsolIOInterface implements RaceIOInterface {
    @Override
    public String[] inputRacersName() {
        return new String[0];
    }

    @Override
    public void showResult(Track track) {

    }
}
