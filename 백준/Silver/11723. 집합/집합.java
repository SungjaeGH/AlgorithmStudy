import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

  private static final HashSet<Integer> numSet = new HashSet<>();

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int commandLine = Integer.parseInt(br.readLine());

    for (int commandIdx = 0; commandIdx < commandLine; commandIdx++) {

      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      String command = st.nextToken();
      int targetNum = 0;

      if (st.hasMoreElements()) {
        targetNum = Integer.parseInt(st.nextToken());
      }

      if (command.equals("add")) {
        add(targetNum);

      } else if (command.equals("remove")) {
        remove(targetNum);

      } else if (command.equals("check")) {
        check(targetNum, bw);

      } else if (command.equals("toggle")) {
        toggle(targetNum);

      } else if (command.equals("all")) {
        all();

      } else if (command.equals("empty")) {
        empty();

      }
    }

    bw.flush();
    bw.close();
  }

  private static void add(int targetNum) {

    if (!numSet.contains(targetNum)) {
      numSet.add(targetNum);
    }
  }

  private static void remove(int targetNum) {

    if (numSet.contains(targetNum)) {
      numSet.remove(targetNum);
    }
  }

  private static void check(int targetNum, BufferedWriter bw) throws IOException {

    if (numSet.contains(targetNum)) {
      bw.write("1\n");

    } else {
      bw.write("0\n");
    }
  }

  private static void toggle(int targetNum) {

    if (numSet.contains(targetNum)) {
      numSet.remove(targetNum);

    } else {
      numSet.add(targetNum);
    }
  }

  private static void all() {

    for (int idx = 1; idx <= 20; idx++) {
      add(idx);
    }
  }

  private static void empty() {

    numSet.clear();
  }
}
