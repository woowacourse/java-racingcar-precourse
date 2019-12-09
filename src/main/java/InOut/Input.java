package inOut;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Input
 */
public class Input {
    private static final int LIMIT = 5;
    Scanner sc = new Scanner(System.in);
    private String[] names;
    private int trys;

    public Input(){
        go();
    }
    
    public String[] getNames(){
        return names;
    }
    
    public int getTrys(){
        return trys;
    }

    public void go(){
        while(true){
            try{
                typeNames();
                break;
            }catch(InputMismatchException e){
                System.out.println("이름은 5자리 이하여야합니다.");
                
            }
        }
        while(true){
            try{
                typeTryNumber();
                break;
            }catch(InputMismatchException e){
                System.out.println("숫자여야합니다.");
                sc = new Scanner(System.in);
                
            }
        }
    }

    public void typeNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String text = sc.nextLine();
        names = text.split(",");
        checkFive();
    }

    public void checkFive(){
        for(int i =0; i<names.length; i++){
            names[i] = names[i].trim(); // 불필요한 앞뒤 공백도 검사 겸 없애줌(단, 중간 공백은 이름 특성상 냅둠.)
            if (names[i].length()>=LIMIT){
                throw new InputMismatchException();
            }
        }
    }


    public void typeTryNumber(){
        System.out.println("시도할 회수는 몇회인가요?");
        int num = sc.nextInt();
        trys= num;
    }

    
}