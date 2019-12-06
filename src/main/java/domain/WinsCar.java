package domain;

public class WinsCar {
    public String wins(Car[] car) {
        StringBuilder winsCar = new StringBuilder();
        int temp = -1;

        for (int i = 0; i < car.length; i++) {
            if (car[i].getPosition() > temp) {
                temp = car[i].getPosition();
                winsCar = new StringBuilder(car[i].getName());
            }
            else if(car[i].getPosition() == temp){
                winsCar.append(car[i].getName());
            }
        }
        return winsCar.toString();
    }
}
