import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] nums = new long[N];
        int count = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        while (st.hasMoreTokens()) {

            long num = Long.parseLong(st.nextToken());
            nums[count] = num;

            count++;
        }

        Arrays.sort(nums);

        int result = 0;

        for (int targetIdx = 0; targetIdx < N; targetIdx++) {

            long target = nums[targetIdx];
            int startIdx = 0, endIdx = N - 1;

            while (startIdx < endIdx) {

                long sum = nums[startIdx] + nums[endIdx];

                if (sum > target) {
                    endIdx--;

                } else if (sum < target) {
                    startIdx++;

                } else {
                    if (startIdx == targetIdx) {
                        startIdx++;

                    } else if (endIdx == targetIdx) {
                        endIdx--;

                    } else {
                        result++;
                        break;
                    }
                }
            }
        }

        System.out.println(result);
    }
}