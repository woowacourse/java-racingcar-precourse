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
        typeNames();;
        typeTryNumber();
    }
    
    public String[] getNames(){
        return names;
    }
    
    public int getTrys(){
        return trys;
    }

    public void typeNames(){
        String text = sc.nextLine();
        names = text.split(",");
    }

    public void typeTryNumber(){
        int num = sc.nextInt();
        trys= num;
    }

}