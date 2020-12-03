package racingcar;

import static racingcar.MessageUtils.printMessageWithConstant;

import java.util.ArrayList;
import java.util.Scanner;

public class Racing {


    public InputUtils racingEvent;

    ArrayList<Car> racerList = new ArrayList<Car>();

    public Racing(Scanner promptInput) {
        // start game prompt
        racingEvent = new InputUtils(promptInput);
        setGrid(racingEvent);
    }

    private void setGrid(InputUtils racingEvent) {
        for (String name : racingEvent.racerNameList) {
            Car racer = new Car(name);
            racerList.add(racer);
        }
    }

    public void standingStart() {
        printMessageWithConstant(new String[]{"\n", Constants.STANDING_START_ANNOUNCEMENT});
        goLap(racingEvent);
    }

    private void goLap(InputUtils racingEvent) {
        for (int i = 1; i <= racingEvent.roundCount; i++) {
            for (Car carInRacingEvent : racerList) {
                carInRacingEvent.moveForward();
                String racerPositionBarInThisLap = getCarPositionInThisLap(carInRacingEvent);
                String[] forwarder = new String[]{carInRacingEvent.getRacerName(),
                    Constants.RACER_POSITION_DIVIDE_CHARACTER, racerPositionBarInThisLap};
                printMessageWithConstant(forwarder);

            }
            printMessageWithConstant(new String[]{});
        }
    }

    private String getCarPositionInThisLap(Car carInRacingEvent) {
        String racerPositionBarInThisLap = "";
        int thisRacerPositionInThisLap = carInRacingEvent.getPosition();
        for (int j = 1; j <= thisRacerPositionInThisLap; j++) {
            racerPositionBarInThisLap += Constants.LAP_POSITION_CHARACTER;
        }
        return racerPositionBarInThisLap;
    }

    public void showAwards() {
        String eventWinnerList = "";
        int maxPositionInRacingEvent = -1;
        maxPositionInRacingEvent = getMaxPosition(maxPositionInRacingEvent);
        eventWinnerList = getRaceWinnerString(maxPositionInRacingEvent);

        String result = eventWinnerList.substring(0, eventWinnerList.length() - 2);
        printMessageWithConstant(new String[]{Constants.EVENT_WINNER_ANNOUNCEMENT, result});
    }

    private int getMaxPosition(int maxPositionInRacingEvent) {
        for (Car carInRacingEvent : racerList) {
            int thisRacerPositionInRacingEvent = carInRacingEvent.getPosition();
            if (maxPositionInRacingEvent < thisRacerPositionInRacingEvent) {
                maxPositionInRacingEvent = thisRacerPositionInRacingEvent;
            }
        }
        return maxPositionInRacingEvent;
    }

    private String getRaceWinnerString(int maxPositionInRacingEvent) {
        String eventWinnerList = "";
        for (Car carInRacingEvent : racerList) {
            int thisRacerPositionInRacingEvent = carInRacingEvent.getPosition();
            if (maxPositionInRacingEvent == thisRacerPositionInRacingEvent) {
                eventWinnerList += carInRacingEvent.getRacerName();
                eventWinnerList += Constants.EVENT_WINNER_FORMAT_CHARACTER;
            }
        }
        return eventWinnerList;
    }
}
