package domain;

public class Message {
    public void playResult(String name, int position) {
	System.out.print(name+" : ");
	for(int i=0;i<position;i++) {
	    System.out.print('-');
	}
	System.out.println();
    }
    
    public void judgeWinner() {}
}
