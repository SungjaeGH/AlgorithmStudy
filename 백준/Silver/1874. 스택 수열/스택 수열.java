import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> targets = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            targets.add(Integer.parseInt(br.readLine()));
        }

        Stack<Integer> stack = new Stack<>();
        int inputNum = 1;
        boolean isOk = true;

        for (int target : targets) {

            if (inputNum <= target) {
                while (inputNum <= target) {

                    sb.append("+\n");
                    stack.push(inputNum++);
                }

                sb.append("-\n");
                stack.pop();

            } else {
                int popNum = stack.pop();
                if (popNum > target) {
                    isOk = false;
                    break;

                } else {
                    sb.append("-\n");
                }
            }
        }

        if (isOk) {
            System.out.println(sb.substring(0, sb.length() - 1));

        } else {
            System.out.println("NO");
        }
    }
}