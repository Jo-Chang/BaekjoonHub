import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		int result = -1;
		int smaller = 0;
		int bigger = 0;
		int jumpOfBigger = 0;
		int jumpOfSmaller = 0;

		if (p > q) {
			bigger = p;
			smaller = q;
			jumpOfBigger = x;
			jumpOfSmaller = y;
		} else if (p < q) {
			bigger = q;
			smaller = p;
			jumpOfBigger = y;
			jumpOfSmaller = x;
		}

		for (int i = 0; i < jumpOfSmaller; i++) {
			if ((bigger - smaller) % jumpOfSmaller == 0) {
				result = bigger;
				break;
			}

			bigger += jumpOfBigger;
		}

		System.out.println(result);
	}

}