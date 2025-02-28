import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();

        for (int idx = 0; idx < N; idx++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        for (int num : list) {
            System.out.println(num);
        }
    }
}