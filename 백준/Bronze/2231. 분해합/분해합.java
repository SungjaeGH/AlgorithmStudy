import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    String inputNumStr = sc.nextLine();
    int inputNum = Integer.parseInt(inputNumStr);

    int minNum = 0;
    for (int idx = 1; idx <= inputNum; idx++) {
      if (generatedSum(idx) == inputNum) {
        minNum = idx;
        break;
      }
    }

    System.out.println(minNum);
  }

  private static int generatedSum(int targetNum) {

    String targetNumStr = String.valueOf(targetNum);
    String[] splitArr = targetNumStr.split("");
    int resultNum = targetNum;

    for (String num : splitArr) {
      resultNum += Integer.parseInt(num);
    }

    return resultNum;
  }
}
