import java.util.*;

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int L = Integer.parseInt(sc.nextLine());
    char[] alphas = sc.nextLine().toCharArray();
    long hashResult = 0;

    for (int idx = 0; idx < L; idx++){

      int num = alphas[idx] - 'a' + 1;

      hashResult += (long)(num * Math.pow(31, idx));
    }

    System.out.println(hashResult);
  }
}
