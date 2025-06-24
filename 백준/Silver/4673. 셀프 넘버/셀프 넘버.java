import java.util.*;

public class Main {

  private static boolean[] visited = new boolean[10001];

  public static void main(String[] args) {

    int limitNum = 10000;

    for (int idx = 1; idx <= limitNum; idx++) {

      if (!visited[idx]) {
        markNotSelfNumber(idx, limitNum);
      }
    }

    for (int idx = 1; idx <= limitNum; idx++) {
      if (!visited[idx]) {
        System.out.println(idx);
      }
    }

  }

  private static void markNotSelfNumber(int targetNum, int limitNum) {

    char[] nums = String.valueOf(targetNum).toCharArray();
    int nextNum = targetNum;

    for (char numChar : nums) {
      nextNum += (numChar - '0');
    }

    if (nextNum <= limitNum) {
      visited[nextNum] = true;
      markNotSelfNumber(nextNum, limitNum);
    }
  }
}
