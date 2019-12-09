package domain;

import java.util.ArrayList;

public class Message {
    public void playResult(String name, int position) {
	System.out.print(name+" : ");
	for(int i=0;i<position;i++) {
	    System.out.print('-');
	}
	System.out.println();
    }
    
    public void judgeWinner(ArrayList<String> winner) {
	int size=winner.size();
	for(int i=0;i<size;i++) {
	    System.out.print(winner.get(i));
	    if((size>1) && i!=size-1) {
		System.out.print(", ");
	    }
	}
<<<<<<< HEAD
	System.out.println("°¡ ÃÖÁ¾ ¿ì½ÂÇß½À´Ï´Ù!");
=======
	System.out.println("ê°€ ìµœì¢… ìš°ìŠ¹í–ˆìŠµë‹ˆë‹¤!");
>>>>>>> 5759ba69089895615a5cf7b57998fd96bb72a234
    }
}
