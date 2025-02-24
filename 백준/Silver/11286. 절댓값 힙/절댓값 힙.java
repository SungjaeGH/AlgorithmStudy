import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {

            int absO1 = Math.abs(o1);
            int absO2 = Math.abs(o2);

            if (absO1 == absO2) {
                return o1 - o2;
            }

            return absO1 - absO2;
        });

        StringBuilder sb = new StringBuilder();

        for (int idx = 0; idx < N; idx++) {

            int x = Integer.parseInt(br.readLine());

            if (x != 0) {
                pq.offer(x);
                continue;
            }

            if (pq.isEmpty()) {
                sb.append("0\n");

            } else {
                sb.append(pq.poll()).append("\n");

            }
        }

        System.out.println(sb.substring(0, sb.length() - 1));
    }
}