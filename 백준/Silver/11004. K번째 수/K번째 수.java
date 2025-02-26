import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String firstLine = br.readLine();
        String[] firstLines = firstLine.split(" ");

        int N = Integer.parseInt(firstLines[0]);
        int K = Integer.parseInt(firstLines[1]);

        ArrayList<Integer> list = new ArrayList<>();
        String secondLine = br.readLine();
        StringTokenizer st = new StringTokenizer(secondLine, " ");

        for (int idx = 0; idx < N; idx++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        System.out.println(list.get(K - 1));
    }
}