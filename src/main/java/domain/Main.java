package domain;

public class Main {
	public static void main(String args[]) {
		String temp = "";
		String[] temp2 = Input.divideNames(temp);
		
		for(int i=0;i<temp2.length;i++) {
			System.out.println(i + ": " + temp2[i]);
		}
	}
}
