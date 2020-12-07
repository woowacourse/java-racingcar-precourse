package View;

public class OutputView {
    private static final String SYMBOL = "-";
    
    public OutputView() {

    }

    public void showState(String name, int score) {
        System.out.println(name + " : "+ scoreMessage(score));
    }

    private String scoreMessage(int score) {
        String message = "";
        for(int index = 0; index < score; index++) {
            message += this.SYMBOL;
        }
        return message;
    }


}
