import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] firstInputSplits = br.readLine().split(" ");
    int N = Integer.parseInt(firstInputSplits[0]);
    int K = Integer.parseInt(firstInputSplits[1]);

    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    for (int idx = 0; idx < N; idx++) {

      int coin = Integer.parseInt(br.readLine());
      pq.offer(coin);
    }

    int minCount = 0;

    while (K > 0) {

      int top = pq.peek();

      if (top > K) {
        pq.poll();

      } else {
        minCount++;
        K -= top;
      }
    }

    System.out.println(minCount);
  }
}
