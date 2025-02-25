import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String N = sc.nextLine();

        char[] nChars = N.toCharArray();

        for (int i = 0; i < nChars.length; i++) {

            char max = nChars[i];
            int swapIdx = -1;

            for (int j = i + 1; j < nChars.length; j++) {

                if (max < nChars[j]) {
                    max = nChars[j];
                    swapIdx = j;
                }
            }

            if (swapIdx == -1) {
                continue;
            }

            nChars[swapIdx] = nChars[i];
            nChars[i] = max;
        }

        for (char nChar : nChars) {
            System.out.print(nChar);
        }
    }
}
