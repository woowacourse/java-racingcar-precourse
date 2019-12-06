package domain;

public class WinsCar {
    public String wins(Car[] car) {
        String winsCar = "";
        int temp = -1;

        for (int i = 0; i < car.length; i++) {
            if (car[i].getPosition() > temp) {
                temp = car[i].getPosition();
                winsCar = car[i].getName();
            }
        }
        return winsCar;
    }
}
