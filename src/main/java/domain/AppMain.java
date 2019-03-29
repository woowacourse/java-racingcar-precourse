package domain;

public class AppMain {

    public static void main(String[] args) {
        Player p = new Player(new RandomNumberGenerator(), new InputValidatorImpl(), new ConsoleUserInterface());

        while (!p.isEnd()) {
            p.doLoop();
        }
    }
}
