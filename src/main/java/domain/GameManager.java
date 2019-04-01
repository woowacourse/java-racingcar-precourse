package domain;

import java.util.ArrayList;

public class GameManager {
    private Message message;
    private InputGameInformation inputgameinformation;
    private ArrayList<Car> car;
    private ArrayList<String> maxPositionCar;
    private int gameCount, carLength, maxPosition;
    private StringBuilder winner;
    private int maxPositionCarLength = 0;

    private void init() {
        message = new Message();
        inputgameinformation = new InputGameInformation();
        car = new ArrayList<>();
        gameCount = 0;
        carLength = 0;
        maxPosition = 0;
        maxPositionCarLength = 0;
        maxPositionCar = new ArrayList<>();
    }

    public void startRacing() {
        init();
        getRacingInformation();
    }

    private void getRacingInformation() {
        inputgameinformation.inputCar();
        car = inputgameinformation.getCar();
        carLength = car.size();
        gameCount = inputgameinformation.getGameCount();
    }

    private void runRacing() {
        for (int i = 0; i < gameCount; i++) {
            finishRacing();
        }
    }

    private void finishRacing() {
        System.out.println(message.gameOutputMessage.get("OUTPUT_GAMERESULT"));
        for (int i = 0; i < carLength; i++) {
            car.get(i).move();
            checkRacingState(i);
        }
        System.out.println();
    }

    private void checkRacingState(int carnumber) {
        int position = car.get(carnumber).getPosition();
        maxPosition = Math.max(maxPosition, position);
        System.out.print(car.get(carnumber).getName()+" : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}
