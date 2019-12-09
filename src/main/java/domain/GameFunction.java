package domain;

public class GameFunction {
    public static void startRacingGame(Car[] cars, int raceCount) {
        for(int i = 0; i < raceCount; i++) {
            moveCars(cars);
        }
    }

    public static void moveCars(Car[] cars) {
        for(Car car : cars){
            if(generateRandomNumber()){
                car.moveCarPosition();
            }
        }
    }

    public static boolean generateRandomNumber(){
        return true;
    }
}
