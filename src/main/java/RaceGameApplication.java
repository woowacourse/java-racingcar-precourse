import logic.RaceSimulator;
import ui.ConsoleIOInterface;

/**
 * @author delf
 */
public class RaceGameApplication {
    public static void main(String[] args) {
        new RaceSimulator().with(new ConsoleIOInterface()).run();
    }
}
