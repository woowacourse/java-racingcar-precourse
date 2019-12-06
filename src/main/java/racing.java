import java.util.*;

import domain.*;

public class racing {
    public static void main(String[] args) {
        int tryCount;
        String carSting = "";
        Car[] car;
        MakeCar makeCar = new MakeCar();
        TryInput tryInput = new TryInput();

        car = makeCar.makingCar();
        tryCount = tryInput.tryInput();

    }
}