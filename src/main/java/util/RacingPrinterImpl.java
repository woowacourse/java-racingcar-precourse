package util;

import domain.RacingCar;

public class RacingPrinterImpl implements RacingPrinter {
    @Override
    public void printStartSign() {
        System.out.println("실행 결과");
    }

    @Override
    public void printRacingCar(RacingCar racingCar) {
        System.out.println(racingCar);
    }
}
