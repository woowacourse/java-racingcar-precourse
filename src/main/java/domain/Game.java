package domain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Game {
	public static void main(String[] agrs) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		bw.write("경주할 자동차 이름을 입력하세요.(이름을 쉼표(,) 기준으로 구분)\n");
		bw.flush();
		String names = bf.readLine();
		bw.write("시도할 회수는 몇 회인가요?\n");
		bw.flush();
		int iter = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(names, ",");
		Cars cars = new Cars();
		
		while(st.hasMoreTokens()) {
			Car car = new Car(st.nextToken());
			cars.addList(car); //입력받은 이름마다 Car 객체를 생성하고 Cars에 추가 
		}
		
		System.out.println("실행결과 ");
		for(int i=0; i<iter; i++) {
			for(int j=0; j<cars.getSize(); j++) {
				cars.playTurn(j);
			}
			System.out.println();
		}
		cars.putResult();
		cars.printResult();
		bw.close();
	}
}
