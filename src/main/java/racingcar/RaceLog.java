package racingcar;

import domain.Car;
import domain.Participants;

public class RaceLog {
    private static final String ENTER = "\n";
    private static final String LOG_FORM = "%s : %s";
    private static final String GRAPH = "-";
    private StringBuilder log;

    private RaceLog() {
        this.log = new StringBuilder();
    }

    public static RaceLog newInstance() {
        return new RaceLog();
    }

    public void writeLog(Participants participants) {
        participants.getParticipants()
                .forEach(this::logCurrentPosition);
        log.append(ENTER);
    }

    private void logCurrentPosition(Car car) {
        String name = car.getName();
        int currentPosition = car.getCurrentPosition();
        String graph = mapToGraph(currentPosition);
        log.append(String.format(LOG_FORM, name, graph));
        log.append(ENTER);
    }

    private String mapToGraph(int currentPosition) {
        StringBuilder graph = new StringBuilder();
        for (int i = 0; i < currentPosition; i++) {
            graph.append(GRAPH);
        }
        return graph.toString();
    }

    public String getLog() {
        return log.toString();
    }
}
