package racingcar;

import java.util.ArrayList;

public interface ICar {
    public void pickRandomNumber();
    public int getPosition();
    public String getName();
    public ArrayList<String> getTrace();
}
