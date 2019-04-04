
import java.lang.StringBuilder;

public class StringBuilderTest {

	static StringBuilder builder = new StringBuilder();
	
	public static void main(String[] args) {
		Long start = System.nanoTime();
		int k = 1000;
		
//		for(int i = 0; i < k; i++) {
//			for(int j = 0; j < i; j++) {
//				System.out.print('-');
//			}
//			System.out.println();
//		}
		
		for(int i = 0; i < k; i++) {
			System.out.println(builder);
			builder.append('-');
		}
		
		Long end = System.nanoTime();
		System.out.println(end-start);
	}
}
// 테스트 결과:
// String        : 대략 1200000000 ns
// StringBuilder : 대략 100000000 ns

