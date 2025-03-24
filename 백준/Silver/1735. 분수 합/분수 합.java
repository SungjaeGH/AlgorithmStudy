import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String firstInput = sc.nextLine();
        String secondInput = sc.nextLine();

        String[] firstInputs = firstInput.split(" ");
        String[] secondInputs = secondInput.split(" ");

        int firstUp = Integer.parseInt(firstInputs[0]);
        int firstDown = Integer.parseInt(firstInputs[1]);
        int secondUp = Integer.parseInt(secondInputs[0]);
        int secondDown = Integer.parseInt(secondInputs[1]);

        int[] firstNums = divNums(firstUp, firstDown);
        int[] secondNums = divNums(secondUp, secondDown);

        int resultUp = ((firstNums[0] * secondNums[1]) + (firstNums[1] * secondNums[0]));
        int resultDown = firstNums[1] * secondNums[1];

        int[] result = divNums(resultUp, resultDown);

        System.out.println(result[0] + " " + result[1]);
    }

    private static int[] divNums(int up, int down) {

        int gcd = findGCD(up, down);
        if (gcd == 1) {
            return new int[]{up, down};
        }

        return divNums(up / gcd, down / gcd);
    }

    private static int findGCD(int first, int second) {

        if (first % second == 0) {
            return second;
        }

        return findGCD(second, first % second);
    }
}
