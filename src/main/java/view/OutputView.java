package view;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행 횟수\n";
    private static final String SEPARATOR_ROUND = "\n";
    private static final String WINNER_MESSAGE = "최종 우승자 : %s \n";
    private static final String ERROR_MESSAGE = "[ERROR] : %s \n";

    private OutputView(){}

    public static void printResultMessage(){
        printMsg(RESULT_MESSAGE);
    }

    public static void printRoundSeparator(){
        printMsg(SEPARATOR_ROUND);
    }

    public static void printWinner(String winners){
        printfMsg(WINNER_MESSAGE, winners);
    }

    public static void printError(String errorMsg){
        printfMsg(ERROR_MESSAGE, errorMsg);
    }

    public static void printfMsg(String msg, Object... args){
        System.out.printf(msg, args);
    }

    public static void printMsg(Object msg){
        System.out.print(msg);
    }
}
