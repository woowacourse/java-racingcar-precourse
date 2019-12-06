package domain;

public class Main {
    public static void main(String[] args) {
        start_game();
    }

    public static void start_game(){
        Manager manager = new Manager();

        System.out.println("실행 결과");
        for(int i=0;i<manager.getNumber();++i){
            manager.cars_go_or_stop();
            manager.print_cars_position();
            System.out.println("");
        }
        manager.print_winner();

    }
}
