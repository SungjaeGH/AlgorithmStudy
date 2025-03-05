import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        int[] data = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < N; idx++) {
            data[idx] = Integer.parseInt(st.nextToken());

        }

        Stack<Integer> s = new Stack<>();

        for (int idx = 0; idx < N; idx++) {
            while (!s.isEmpty() && data[s.peek()] < data[idx]) {
                data[s.pop()] = data[idx];
            }

            s.add(idx);
        }

        while (!s.isEmpty()) {
            data[s.pop()] = -1;
        }

        for (int idx = 0; idx < N; idx++) {
            sb.append(data[idx]).append(" ");
        }

        System.out.println(sb);
    }
}