package racingcar;

import java.util.ArrayList;
import java.util.Scanner;

public class Racing {

    public static final String STANDING_START_ANNOUNCEMENT = "실행 결과";
    public static final String LAP_POSITION_CHARACTER = "-";
    public static final String RACER_POSITION_DIVIDE_CHARACTER = " : ";
    public static final String EVENT_WINNER_ANNOUNCEMENT = "최종 우승자: ";
    public static final String EVENT_WINNER_FORMAT_CHARACTER = ", ";

    public StringUtils racingEvent;

    ArrayList<Car> racerList = new ArrayList<Car>();

    public Racing(Scanner promptInput) {
        // start game prompt
        racingEvent = new StringUtils(promptInput);
        setGrid(racingEvent);
    }

    private void setGrid(StringUtils racingEvent) {
        for (String name : racingEvent.racerNameList) {
            Car racer = new Car(name);
            racerList.add(racer);
        }
    }

    public void standingStart() {
        System.out.println(STANDING_START_ANNOUNCEMENT);
        for (int i = 1; i <= racingEvent.roundCount; i++) {
            System.out.println(i + " Round.");
            for (Car carInRacingEvent : racerList) {
                carInRacingEvent.moveForward();
                String racerPositionBarInThisLap = "";
                int thisRacerPositionInThisLap = carInRacingEvent.getPosition();
                for (int j = 1; j <= thisRacerPositionInThisLap; j++) {
                    racerPositionBarInThisLap += LAP_POSITION_CHARACTER;
                }
                System.out
                    .println(
                        carInRacingEvent.getRacerName() + RACER_POSITION_DIVIDE_CHARACTER
                            + carInRacingEvent.getPosition()
                            + racerPositionBarInThisLap);
            }
        }
    }

    public void showAwards() {
        String eventWinnerList = "";
        int maxPositionInRacingEvent = -1;
        for (Car carInRacingEvent : racerList) {
            int thisRacerPositionInRacingEvent = carInRacingEvent.getPosition();
            if (maxPositionInRacingEvent < thisRacerPositionInRacingEvent) {
                maxPositionInRacingEvent = thisRacerPositionInRacingEvent;
            }
        }
        for (Car carInRacingEvent : racerList) {
            int thisRacerPositionInRacingEvent = carInRacingEvent.getPosition();
            if (maxPositionInRacingEvent == thisRacerPositionInRacingEvent) {
                eventWinnerList += carInRacingEvent.getRacerName();
                eventWinnerList += EVENT_WINNER_FORMAT_CHARACTER;
            }
        }
        String result = eventWinnerList.substring(0, eventWinnerList.length() - 2);
        System.out.println(EVENT_WINNER_ANNOUNCEMENT + result);
    }
}
