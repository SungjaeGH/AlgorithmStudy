import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int count = 0;

        count = Math.min(input, 99);

        for (int idx = count + 1; idx <= input; idx++) {

            char[] digits = String.valueOf(idx).toCharArray();
            int compare = digits[0] - digits[1];
            boolean isOne = true;

            for (int targetIdx = 1; targetIdx < digits.length - 1; targetIdx++) {
                if (digits[targetIdx] - digits[targetIdx + 1] != compare) {
                    isOne = false;
                    break;
                }
            }

            if (isOne) {
                count++;
            }
        }

        System.out.println(count);
    }
}