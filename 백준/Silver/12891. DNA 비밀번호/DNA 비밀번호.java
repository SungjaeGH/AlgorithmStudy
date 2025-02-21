import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputStr = br.readLine();
        String[] inputs = inputStr.split(" ");
        int S = Integer.parseInt(inputs[0]);
        int P = Integer.parseInt(inputs[1]);

        String dnaStr = br.readLine();
        char[] dnaChars = dnaStr.toCharArray();

        String[] acgt = new String[]{"A", "C", "G", "T"};
        HashMap<String, Integer> acgtCount = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int idx = 0; idx < acgt.length; idx++) {

            int count = Integer.parseInt(st.nextToken());

            if (count > 0) {
                acgtCount.put(acgt[idx], count);
            }
        }

        int startIdx = 0, endIdx = P - 1;
        HashMap<String, Integer> dnaCount = new HashMap<>();

        for (int idx = startIdx; idx <= endIdx; idx++) {
            String dna = String.valueOf(dnaChars[idx]);

            if (dnaCount.containsKey(dna)) {
                int count = dnaCount.get(dna);
                dnaCount.put(dna, ++count);

            } else {
                dnaCount.put(dna, 1);

            }
        }

        int result = 0;

        while (endIdx != S) {

            boolean isValid = true;

            for (int idx = 0; idx < acgt.length; idx++) {

                String target = acgt[idx];

                if (!acgtCount.containsKey(target)) {
                    continue;
                }

                if (!dnaCount.containsKey(target)) {
                    isValid = false;
                    break;
                }

                if (dnaCount.get(target) < acgtCount.get(target)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                result++;
            }

            startIdx++;
            endIdx++;

            if (endIdx != S) {
                String minusTarget = String.valueOf(dnaChars[startIdx - 1]);
                String plusTarget = String.valueOf(dnaChars[endIdx]);

                if (dnaCount.containsKey(minusTarget)) {
                    int count = dnaCount.get(minusTarget);
                    if (count == 1) {
                        dnaCount.remove(minusTarget);

                    } else {
                        dnaCount.put(minusTarget, --count);
                    }
                }

                if (dnaCount.containsKey(plusTarget)) {
                    int count = dnaCount.get(plusTarget);
                    dnaCount.put(plusTarget, ++count);

                } else {
                    dnaCount.put(plusTarget, 1);
                }
            }
        }

        System.out.println(result);
    }
}