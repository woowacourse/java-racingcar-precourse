package system;

import io.InputRacingCar;

import java.util.Arrays;
import java.util.StringTokenizer;

public class RacingCarSystem {
    private String[] setCarNameArr;

    public void setUpRacing() {
        String carsName = InputRacingCar.inputCarsName();
        setCarNameArr(carsName);
    }

    public void setCarNameArr(String carsName) {
        StringTokenizer st = new StringTokenizer(carsName, ",");
        setCarNameArr = new String[st.countTokens()];

        int index = 0;
        while (st.hasMoreTokens()) {
            setCarNameArr[index] = st.nextToken();
            index++;
        }
    }
}
