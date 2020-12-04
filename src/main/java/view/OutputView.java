package view;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행 횟수\n";
    private static final String SEPARATOR_ROUND = "\n";

    private OutputView(){}

    public static void printResultMessage(){
        printMsg(RESULT_MESSAGE);
    }

    public static void printRoundSeparator(){
        printMsg(SEPARATOR_ROUND);
    }

    public static void printfMsg(String msg, Object... args){
        System.out.printf(msg, args);
    }

    public static void printMsg(Object msg){
        System.out.print(msg);
    }
}
