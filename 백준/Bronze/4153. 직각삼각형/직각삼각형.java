import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    boolean isEnd = false;

    while (!isEnd) {

      StringTokenizer st = new StringTokenizer(br.readLine(), " ");

      int first = Integer.parseInt(st.nextToken());
      int second = Integer.parseInt(st.nextToken());
      int third = Integer.parseInt(st.nextToken());

      if (first == 0 && second == 0 && third == 0) {
        isEnd = true;
        break;
      }

      List<Integer> list = new ArrayList<>(List.of(first, second, third));
      Collections.sort(list);

      if (Math.pow(list.get(0), 2) + Math.pow(list.get(1), 2) == Math.pow(list.get(2), 2)) {
        bw.write("right\n");

      } else {
        bw.write("wrong\n");
      }
    }

    bw.flush();
    bw.close();
  }
}
