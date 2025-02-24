import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();

        int N = sc.nextInt();

        for (int idx = 1; idx <= N; idx++) {
            queue.add(idx);
        }

        boolean move = false;

        while (queue.size() > 1) {

            int popNum = queue.poll();

            if (move) {
                queue.offer(popNum);
                move = false;

            } else {
                move = true;

            }
        }

        System.out.println(queue.poll());
    }
}