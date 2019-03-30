public class testMethod {
    public boolean isMovePosition() {
        int randomNumber = (int) (Math.random() * 10);
        System.out.print(randomNumber + ", ");
        return ((randomNumber >= 4) ? true : false);
    }

    public static void main(String[] args){
        testMethod t = new testMethod();
        for(int i=0; i<9; i++){
            System.out.println(t.isMovePosition());
        }
    }
}
