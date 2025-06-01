import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] tShirtsCount = new int[6];

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int idx = 0; idx < tShirtsCount.length; idx++) {
      tShirtsCount[idx] = Integer.parseInt(st.nextToken());
    }

    String[] thirdInput = br.readLine().split(" ");
    int T = Integer.parseInt(thirdInput[0]);
    int P = Integer.parseInt(thirdInput[1]);

    int minTShirts = 0;
    for (int count : tShirtsCount) {

      if (count % T == 0) {
        minTShirts += count / T;

      } else {
        minTShirts += (count / T + 1);
      }
    }

    System.out.println(minTShirts);
    System.out.println((N / P) + " " + (N % P));
  }
}
