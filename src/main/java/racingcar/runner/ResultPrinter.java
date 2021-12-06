package racingcar.runner;

public class ResultPrinter {

    private static final String OUT_HEADER = "실행결과";
    private static final String LINE_BREAK = "\n";

    private final StringBuilder buffer;

    public ResultPrinter() {
        this.buffer = new StringBuilder();
        appendNewLine(OUT_HEADER);
    }

    public void appendResultBlock(String line) {
        appendNewLine(line);
    }

    public void printResult() {
        System.out.print(buffer);
    }

    public void appendNewLine(String line) {
        this.buffer.append(line).append(LINE_BREAK);
    }
}
