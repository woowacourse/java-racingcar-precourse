package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
        if (!getRacingInformation()) {
            runRacing();
            judgeRacing();
        }else{
            startRacing();
        }
    }

    private boolean getRacingInformation() {
        inputgameinformation.inputCar();
        car = inputgameinformation.getCar();
        carLength = car.size();
        if (carLength == 0) {
            System.out.println(Message.errorMessage.get("ERROR_NAMEEMPTY"));
            return true;
        }
        gameCount = inputgameinformation.getGameCount();
        return false;
    }

    private void runRacing() {
        System.out.println(message.gameOutputMessage.get("OUTPUT_GAMERESULT"));
        for (int i = 0; i < gameCount; i++) {
            finishRacing();
        }
    }

    private void finishRacing() {
        for (Car c : car){
            c.move();
            checkRacingState(c);
        }
        System.out.println();
    }

    private void checkRacingState(Car c) {
        int position = c.getPosition();
        maxPosition = Math.max(maxPosition, position);
        System.out.print(c.getName()+" : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private void judgeRacing() {
        maxPositionArray();
        boolean winnercheck = true;
        int carnumber = 0;
        while (winnercheck) {
            winnercheck = checkForMaxPositionFromCar(carnumber++);
        }
        winnerOfRacing();
    }

    /*
     * MaxPositionArray() : Position이 높은 순으로 정렬
     */
    private void maxPositionArray() {
        Collections.sort(car, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                if (o1.getPosition() > o2.getPosition()) {
                    return -1;
                }
                if (o1.getPosition() == o2.getPosition()) {
                    return 0;
                }
                else {
                    return 1;
                }
            }
        });
    }

    /*
     * checkForMaxPositionFromCar() : MaxPosition RacingCar
     */
    private boolean checkForMaxPositionFromCar(int carnumber) {
        if (carnumber >= carLength) {
            return false;
        }
        if (car.get(carnumber).getPosition() == maxPosition) {
            maxPositionCar.add(car.get(carnumber).getName());
            return true;
        }
        return false;
    }

    private void winnerOfRacing() {
        maxPositionCarLength = maxPositionCar.size();
        winner = new StringBuilder();
        int winnerLength = maxPositionCar.size();
        for (int i = 0; i < winnerLength; i++) {
            winner.append(maxPositionCar.get(i));
            commaCheck(i + 1);
        }
        System.out.println(winner.toString() + message.gameOutputMessage.get("OUTPUT_GAMEWINNER"));
    }

    private void commaCheck(int Lastindex) {
        if (Lastindex == maxPositionCarLength) {
            return;
        }
        winner.append(", ");
    }

}
