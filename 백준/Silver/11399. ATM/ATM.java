import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        sc.nextLine();

        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        ArrayList<Integer> times = new ArrayList<>();

        while (st.hasMoreTokens()) {
            times.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i < N; i++) {

            int targetTime = times.get(i);
            int insertIdx = i;

            for (int j = i - 1; j >= 0; j--) {

                if (targetTime < times.get(j)) {
                    insertIdx = j;
                }
            }

            times.remove(i);
            times.add(insertIdx, targetTime);
        }

        int sum = 0, lastTime = 0;

        for (int time : times) {
            lastTime += time;
            sum += lastTime;
        }

        System.out.println(sum);

    }
}