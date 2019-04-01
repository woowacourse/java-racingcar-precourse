package playRacing;

public class Main {
    public static void main(String[] args) {

    }
  
    public static boolean isNameValid(String[] names){
        for(int i=0; i<names.length; i++){
            if(names[i].length()>5){
                return false;
            }
        }
        return true;
    }
}
