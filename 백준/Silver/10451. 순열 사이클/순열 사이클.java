import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        ArrayList<Integer> results = new ArrayList<>();

        for (int testcaseIdx = 0; testcaseIdx < T; testcaseIdx++) {

            HashMap<Integer, Integer> map = new HashMap<>();

            int N = Integer.parseInt(br.readLine());
            String[] numsStr = br.readLine().split(" ");

            for (int idx = 0; idx < N; idx++) {
                map.put(idx + 1, Integer.parseInt(numsStr[idx]));
            }

            int count = countCycleGraph(N, map);
            results.add(count);
        }

        for (int result : results) {
            System.out.println(result);
        }

    }

    private static int countCycleGraph(int N, HashMap<Integer, Integer> map) {

        boolean[] visited = new boolean[N];
        int count = 0;

        for (int idx = 0; idx < N; idx++) {

            if (visited[idx]) {
                continue;
            }

            if (findCycleGraph(idx, map, visited)) {
                count++;
            }
        }

        return count;
    }

    private static boolean findCycleGraph(int start, HashMap<Integer, Integer> map, boolean[] visited) {

        int curr = start;

        while (!visited[curr]) {

            visited[curr] = true;
            if (!map.containsKey(curr + 1)) {
                return false;
            }

            curr = map.get(curr + 1) - 1;
        }

        return curr == start;
    }
}