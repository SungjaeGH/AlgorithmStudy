import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String firstLine = br.readLine();
        String[] inputs = firstLine.split(" ");
        int L = Integer.parseInt(inputs[0]);
        int C = Integer.parseInt(inputs[1]);

        ArrayList<String> words = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int idx = 0; idx < C; idx++) {
            words.add(st.nextToken());
        }

        Collections.sort(words);

        for (int idx = 0; idx < C; idx++) {

            String target = words.get(idx);

            Password pw = new Password();
            pw.currIdx = idx;
            pw.passwordInfo = target;
            pw.countWordType(target);

            findPassword(pw, L, words, bw);
        }

        bw.flush();
        bw.close();
    }

    public static class Password {

        public int currIdx;
        public String passwordInfo;
        public int consonantCount;
        public int vowelCount;

        public Password() {
        }

        public void countWordType(String target) {
            if (target.equals("a") || target.equals("e") || target.equals("i") || target.equals("o") || target.equals("u")) {
                this.vowelCount++;

            } else {
                this.consonantCount++;
            }
        }
    }

    private static void findPassword(Password curr, int L, ArrayList<String> words, BufferedWriter bw) throws IOException {

        if (curr.passwordInfo.length() == L) {

            if (curr.consonantCount >= 2 && curr.vowelCount >= 1) {
                bw.write(curr.passwordInfo + "\n");
            }

            return;
        }

        for (int nextIdx = curr.currIdx + 1; nextIdx < words.size(); nextIdx++) {

            String nextTarget = words.get(nextIdx);
            Password nextPw = new Password();

            nextPw.currIdx = nextIdx;
            nextPw.passwordInfo = curr.passwordInfo + nextTarget;
            nextPw.consonantCount = curr.consonantCount;
            nextPw.vowelCount = curr.vowelCount;

            nextPw.countWordType(nextTarget);

            findPassword(nextPw, L, words, bw);
        }
    }
}