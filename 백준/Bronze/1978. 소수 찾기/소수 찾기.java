import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int count = 0;
        while(st.hasMoreTokens()) {

            int target = Integer.parseInt(st.nextToken());
            boolean isDecimal = true;

            if (target == 1) {
                isDecimal = false;
            }

            for (int i = 2; i < target; i++) {
                if (target % i == 0) {
                    isDecimal = false;
                    break;
                }
            }

            if (isDecimal) {
                count++;
            }
        }

        System.out.println(count);
    }
}