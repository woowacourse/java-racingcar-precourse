package racingcar.utils;

public class DisplayHandler {

    final public static String OUT_HEADER = "실행결과";
    final private static String LINE_BREAK = "\n";

    final private StringBuilder buffer;

    public DisplayHandler() {
        this.buffer = new StringBuilder();
        appendWithLineBreak(OUT_HEADER);
    }

    public void appendResultBlock(String line) {
        appendWithLineBreak(line);
    }

    public void appendWithLineBreak(String line) {
        this.buffer.append(line).append(LINE_BREAK);
    }

    public void displayResult() {
        System.out.print(buffer);
    }
}
