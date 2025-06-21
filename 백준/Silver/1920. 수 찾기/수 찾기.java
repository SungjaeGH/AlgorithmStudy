import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {

   BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    HashSet<Integer> numSet = new HashSet<>();

    for (int idx = 0; idx < N; idx++){
      numSet.add(Integer.parseInt(st.nextToken()));
    }

    int M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine(), " ");

    for (int idx = 0; idx < M; idx++){

      int target = Integer.parseInt(st.nextToken());

      if (numSet.contains(target)) {
        System.out.println("1");

      } else {
        System.out.println("0");
      }
    }
  }
}
