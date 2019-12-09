package inOut;
import java.util.Scanner;

/**
 * Input
 */
public class Input {
    Scanner sc = new Scanner(System.in);
    private String[] names;
    private int trys;

    public Input(){
        String text = sc.nextLine();
        names = text.split(",");
    }
    public String[] getNames(){
        return names;
    }
    public int getTrys(){
        return trys;
    }
}