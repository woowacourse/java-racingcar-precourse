package racingcar.domain;

public class Recorder {
    private static final String NEW_LINE = System.lineSeparator();

    private StringBuilder gameRecord;

    public Recorder() {
        this.gameRecord = new StringBuilder();
    }

    public void record(String record) {
        gameRecord.append(record + NEW_LINE);
    }

    public String getRecord() {
        return this.gameRecord.toString();
    }
}
